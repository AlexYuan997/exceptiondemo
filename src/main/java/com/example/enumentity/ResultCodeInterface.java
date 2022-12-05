package com.example.enumentity;

public interface ResultCodeInterface {
    /**
     * 错误码
     *
     * @return 错误码
     */
    Integer code();

    /**
     * 错误具体信息
     *
     * @return 错误具体信息
     */
    String message();
}
