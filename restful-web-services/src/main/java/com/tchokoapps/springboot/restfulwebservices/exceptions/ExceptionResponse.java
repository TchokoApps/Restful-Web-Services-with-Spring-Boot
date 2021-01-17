package com.tchokoapps.springboot.restfulwebservices.exceptions;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;
}
