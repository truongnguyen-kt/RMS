package com.blues.common.env.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = false)
public class FileUploadResponse {
    private String filename;
    private String fileId;
    private String fileExtension;
}
