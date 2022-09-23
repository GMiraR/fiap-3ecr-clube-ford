package br.com.fiap.fordclub.model;

import br.com.fiap.fordclub.entity.Reward;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="images")
public class RewardImage {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String uuid;

    @URL
    @Column(nullable = false, columnDefinition = "text")
    private String url;

}
