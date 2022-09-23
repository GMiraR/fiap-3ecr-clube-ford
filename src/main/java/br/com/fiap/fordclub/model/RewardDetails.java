package br.com.fiap.fordclub.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RewardDetails {

    private String name;

    private String year;

    private LocalDateTime validUntil;
}
