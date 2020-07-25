package com.project.library.api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    private String mailAddress;
    private String subject;
    private String message;
}
