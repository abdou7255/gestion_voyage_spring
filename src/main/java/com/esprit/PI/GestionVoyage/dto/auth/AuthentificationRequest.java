package com.esprit.PI.GestionVoyage.dto.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthentificationRequest {
    private String email;
    private String password;
}
