package com.esprit.PI.GestionVoyage.dto.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthentificationCompanyRequest {
    private String emailAddress;
    private String password;
}
