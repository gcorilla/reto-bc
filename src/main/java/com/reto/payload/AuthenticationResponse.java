package com.reto.payload;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class AuthenticationResponse {

        private String token;
        private long expiresIn;

}

