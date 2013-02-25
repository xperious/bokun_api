package is.bokun.dtos;

import java.util.*;

/**
 * @author Olafur Gauti Gudmundsson
 */
public class ApiResponse {

    public String message;
    public Map<String,Object> fields = new HashMap<>();

    public ApiResponse(){}

    public ApiResponse(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getFields() {
        return fields;
    }

    public void setFields(Map<String, Object> fields) {
        this.fields = fields;
    }
}
