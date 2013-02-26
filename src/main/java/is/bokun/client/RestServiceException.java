package is.bokun.client;

import is.bokun.dtos.ApiResponse;

/**
 * This exception is thrown from client methods when the status code of the response is not OK (200).
 *
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
