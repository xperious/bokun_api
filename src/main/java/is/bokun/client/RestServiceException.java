package is.bokun.client;

import is.bokun.dtos.ApiResponse;

/**
 * @author Olafur Gauti Gudmundsson
 */
public class RestServiceException extends RuntimeException {

    private final ApiResponse apiResponse;

    public RestServiceException(ApiResponse apiResponse) {
        super(apiResponse.message);
        this.apiResponse = apiResponse;
    }

    public RestServiceException(ApiResponse apiResponse, Throwable rootCause) {
        super(apiResponse.message, rootCause);
        this.apiResponse = apiResponse;
    }

    public ApiResponse getApiResponse() {
        return apiResponse;
    }
}
