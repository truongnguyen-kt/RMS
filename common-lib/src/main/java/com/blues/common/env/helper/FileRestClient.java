package com.blues.common.env.helper;

import com.blues.common.env.dto.FileUploadResponse;
import com.google.common.io.Files;
import io.minio.*;
import io.minio.errors.MinioException;
import io.minio.http.Method;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileRestClient {
    private final MinioClient minioClient;

    public FileUploadResponse uploadFile(MultipartFile file, String bucket, String subPath, String allowedExtension) throws IOException {
        String var10000 = this.buildPathFile(subPath, UUID.randomUUID().toString().replace("-", ""));
        String objectMinIO = var10000 + "." + Files.getFileExtension((String) Objects.requireNonNull(file.getOriginalFilename()));
        String[] allowedExtensions = allowedExtension.split(",");
        String fileExtension = Files.getFileExtension((String) Objects.requireNonNull(file.getOriginalFilename())).toLowerCase();
        boolean isValidExtension = false;

        for (String extension : allowedExtensions) {
            if (fileExtension.equals(extension)) {
                isValidExtension = true;
                break;
            }
        }

        if (!isValidExtension) {
            throw new IOException("Invalid file format. Only image files are allowed.");
        } else {
            try (InputStream fileStream = file.getInputStream()) {
                this.minioClient.putObject((PutObjectArgs) ((PutObjectArgs.Builder) ((PutObjectArgs.Builder) PutObjectArgs.builder().bucket(bucket)).object(objectMinIO)).stream(fileStream, file.getSize(), -1L).contentType(file.getContentType()).build());
            } catch (IOException | MinioException e) {
                throw new IOException("Error uploading file to MinIO: " + ((Exception) e).getMessage(), e);
            } catch (InvalidKeyException | NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }

            return new FileUploadResponse(file.getOriginalFilename(), objectMinIO, fileExtension);
        }
    }

    public byte[] download(String fileId, String bucket) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        try (InputStream fileStream = this.minioClient.getObject((GetObjectArgs) ((GetObjectArgs.Builder) ((GetObjectArgs.Builder) GetObjectArgs.builder().bucket(bucket)).object(fileId)).build())) {
            return fileStream.readAllBytes();
        } catch (IOException | MinioException e) {
            throw new IOException("Error retrieving file from MinIO: " + ((Exception) e).getMessage(), e);
        }
    }

    public void deleteFile(String fileId, String bucket) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            this.minioClient.removeObject((RemoveObjectArgs) ((RemoveObjectArgs.Builder) ((RemoveObjectArgs.Builder) RemoveObjectArgs.builder().bucket(bucket)).object(fileId)).build());
        } catch (IOException | MinioException e) {
            throw new IOException("Error deleting file from MinIO: " + ((Exception) e).getMessage(), e);
        }
    }

    public String getPresignedUrl(String bucketName, String fileName) {
        bucketName = bucketName.toLowerCase();
        String url = "";
        try {
            url = minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
                    .method(Method.GET)
                    .bucket(bucketName)
                    .object(fileName)
                    .build());
        } catch (MinioException | IOException | InvalidKeyException | NoSuchAlgorithmException e) {
            System.out.println("Error occurred: " + e);
        }
        return url;
    }

    private String buildPathFile(String subPath, String fileName) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        String formattedDate = dateFormat.format(date);
        return subPath + "/" + formattedDate + "/" + fileName;
    }
}
