package br.com.fiap.fordclub.controller.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CategoryResponse {

    private String uuid;
    private String name;
    private String description;
    private String childrenCategoryId;
}
