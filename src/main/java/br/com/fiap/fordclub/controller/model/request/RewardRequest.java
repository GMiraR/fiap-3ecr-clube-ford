package br.com.fiap.fordclub.controller.model.request;

import br.com.fiap.fordclub.model.RewardDestination;
import br.com.fiap.fordclub.model.RewardDetails;
import br.com.fiap.fordclub.model.RewardImage;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RewardRequest {

    private String name;

    private String description;

    private Long points;

    private RewardDestination destination;

    private RewardDetails details;

    private Set<RewardImage> images = new HashSet<>();

    private String partnerId;

    private String categoryId;
}
