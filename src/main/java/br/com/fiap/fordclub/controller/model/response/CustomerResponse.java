package br.com.fiap.fordclub.controller.model.response;

import br.com.fiap.fordclub.entity.Reward;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CustomerResponse {

    private String uuid;
    private String firstName;
    private String lastName;
    private String email;
    private String document;
    private String status;
    private Long wallet;
    private List<Reward> rewards;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime updatedAt;

}