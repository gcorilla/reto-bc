package com.reto.payload;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AuthenticationLogin {
    private String cellphone;
    private String password;
}
