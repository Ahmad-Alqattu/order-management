package org.example.payload;

import lombok.Data;

@Data
public class SignsUpDto {
    private String name;
    private String username;
    private String email;
    private String password;
}
