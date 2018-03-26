package com.jiabiango.profits.exception;

import com.jiabiango.profits.constant.ApiResultCode;

public class ApiException extends RuntimeException {

    private static final long serialVersionUID = -1806344442319961806L;

    private String erroCode;
    
    public ApiException(String message) {
        super(message);
        this.erroCode = ApiResultCode.API_ERR_CODE;
    }

    public ApiException(String erroCode, String message) {
        super(message);
        this.erroCode = erroCode;
    }
    
    public String getErroCode() {
        return erroCode;
    }
    
    public void setErroCode(String erroCode) {
        this.erroCode = erroCode;
    }
}
