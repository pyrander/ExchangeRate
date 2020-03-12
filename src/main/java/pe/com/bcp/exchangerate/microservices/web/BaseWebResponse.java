package pe.com.bcp.exchangerate.microservices.web;

import lombok.Builder;
import lombok.Getter;
import pe.com.bcp.exchangerate.microservices.exception.ErrorCode;

@Getter
@Builder
public class BaseWebResponse<T> {
    private ErrorCode errorCode;
    private T data;

    @SuppressWarnings("rawtypes")
	public static BaseWebResponse successNoData() {
        return BaseWebResponse.builder()
                .build();
    }

    public static <T> BaseWebResponse<T> successWithData(T data) {
        return BaseWebResponse.<T>builder()
                .data(data)
                .build();
    }

    @SuppressWarnings("rawtypes")
	public static BaseWebResponse error(ErrorCode errorCode) {
        return BaseWebResponse.builder()
                .errorCode(errorCode)
                .build();
    }
}