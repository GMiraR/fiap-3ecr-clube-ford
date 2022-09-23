package br.com.fiap.fordclub.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RewardDestination {

    private String country;
    private String city;
    private String takeOut;
    private String destination;
}
