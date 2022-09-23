package br.com.fiap.fordclub.entity;

import br.com.fiap.fordclub.entity.enums.RewardStatus;
import br.com.fiap.fordclub.model.RewardDestination;
import br.com.fiap.fordclub.model.RewardDetails;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@TypeDef(typeClass = JsonType.class, defaultForType = RewardDetails.class)
@TypeDef(typeClass = JsonType.class, defaultForType = RewardDestination.class)
@TypeDef(name = "json", typeClass = JsonType.class)
@Table(name="rewards")
public class Reward {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String uuid;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "points")
    private Long points;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private RewardStatus status;

    @Type(type = "json")
    @Column(name = "destination", columnDefinition = "JSON")
    private RewardDestination destination;

    @Type(type = "json")
    @Column(name = "details", columnDefinition = "JSON")
    private RewardDetails details;

//    @Type(type = "json")
//    @Column(name = "images", columnDefinition = "JSON")
//    private Set<RewardImage> images = new HashSet<>();

    @ManyToOne
    private Partner partner;

    @ManyToOne
    private RewardCategory category;

    @Column(name = "expire_at", updatable = false)
    private LocalDateTime expireAt;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
