package br.com.fiap.fordclub.controller.model.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequest {

    @NotEmpty(message = "Informe o nome, por gentileza.")
    private String firstName;

    @NotEmpty(message = "Informe o sobrenome, por gentileza.")
    private String lastName;

    @NotEmpty(message = "Informe o nome, por gentileza.")
    private String email;

    @NotEmpty(message = "Informe o nome, por gentileza.")
    private String document;

}
