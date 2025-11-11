package com.blues.common.env.enums;

import com.blues.common.env.response.BaseResponseCode;

public enum PlatformResponseCode implements BaseResponseCode {
    EXCEPTION_ERROR("EXCEPTION_ERROR", "Đã xảy ra lỗi hệ thống. Vui lòng thử lại sau hoặc liên hệ quản trị viên."),
    HTTP_ERROR("HTTP_ERROR", "Đã xảy ra lỗi hệ thống. Vui lòng thử lại sau hoặc liên hệ quản trị viên."),
    BAD_REQUEST("BAD_REQUEST", "Yêu cầu không hợp lệ. Vui lòng kiểm tra lại thông tin gửi lên."),
    REQUEST_TIMEOUT("REQUEST_TIMEOUT", "Hệ thống phản hồi chậm. Vui lòng thử lại sau."),
    VALIDATION_FAILED("VALIDATION_FAILED", "Dữ liệu không hợp lệ. Vui lòng kiểm tra và thử lại."),
    MISSING_PARAMETER("MISSING_PARAMETER", "Thiếu thông tin cần thiết trong yêu cầu."),
    UNAUTHORIZED("UNAUTHORIZED", "Bạn chưa được xác thực. Vui lòng đăng nhập để tiếp tục."),
    FORBIDDEN("FORBIDDEN", "Bạn không có quyền thực hiện chức năng này."),
    NOT_FOUND("NOT_FOUND", "Không tìm thấy tài nguyên được yêu cầu."),
    RESOURCE_NOT_FOUND("RESOURCE_NOT_FOUND", "Tài nguyên không tồn tại hoặc đã bị xóa."),
    CONFLICT("CONFLICT", "Dữ liệu đã tồn tại hoặc bị trùng lặp."),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", "Lỗi hệ thống. Vui lòng thử lại sau."),
    BUSINESS_ERROR("BUSINESS_ERROR", "Đã xảy ra lỗi nghiệp vụ. Vui lòng liên hệ quản trị viên."),
    SERVICE_ERROR("SERVICE_ERROR", "Lỗi xử lý dịch vụ. Vui lòng thử lại sau."),
    RATE_LIMIT_EXCEEDED("RATE_LIMIT_EXCEEDED", "Bạn đã gửi quá nhiều yêu cầu. Vui lòng thử lại sau."),
    USER_ERROR("USER_ERROR", "Lỗi liên quan đến người dùng. Vui lòng kiểm tra lại thông tin."),
    EXTERNAL_SERVICE_ERROR("EXTERNAL_SERVICE_ERROR", "Không thể kết nối tới dịch vụ bên ngoài. Vui lòng thử lại sau."),
    CACHE_ERROR("CACHE_ERROR", "Lỗi truy xuất bộ nhớ đệm. Vui lòng thử lại sau."),
    APP_SERVICE_ERROR("APP_SERVICE_ERROR", "Lỗi từ dịch vụ ứng dụng. Vui lòng liên hệ hỗ trợ."),
    INFRA_ERROR("INFRA_ERROR", "Lỗi hạ tầng. Vui lòng kiểm tra hệ thống."),
    DB_ERROR("DB_ERROR", "Lỗi hệ thống cơ sở dữ liệu. Vui lòng thử lại sau."),
    DB_CONNECTION_ERROR("DB_CONNECTION_ERROR", "Không thể kết nối cơ sở dữ liệu. Vui lòng kiểm tra cấu hình."),
    DB_QUERY_ERROR("DB_QUERY_ERROR", "Lỗi truy vấn dữ liệu. Vui lòng kiểm tra lại dữ liệu đầu vào."),
    DB_DATA_INTEGRITY_ERROR("DB_DATA_INTEGRITY_ERROR", "Dữ liệu không đảm bảo tính toàn vẹn. Vui lòng kiểm tra lại.");

    private final String code;
    private final String message;

    private PlatformResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
