package br.com.fiap.fordclub.controller.model.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryRequest {

    @NotEmpty(message = "Informe o nome, por gentileza.")
    private String name;

    @NotEmpty(message = "Informe uma descrição, por gentileza.")
    private String description;

}