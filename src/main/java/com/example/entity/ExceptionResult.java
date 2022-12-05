package com.example.entity;

import lombok.Data;

@Data
public class ExceptionResult {
    Boolean isThrow;

    Exception ex;

}
