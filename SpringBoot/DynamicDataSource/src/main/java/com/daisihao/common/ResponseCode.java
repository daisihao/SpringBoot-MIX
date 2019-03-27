package com.daisihao.common;

public enum ResponseCode {

    SUCCESS(200),
    FAIL(400);

    public int code;

    ResponseCode(int code) {
        this.code = code;
    }
}
