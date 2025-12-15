package ma.soufiane.conferenceservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.soufiane.conferenceservice.model.Keynote;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Conference {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    @Enumerated(EnumType.STRING)
    private Type type;

    private LocalDateTime date;

    private Integer duree;

    private Integer nombreInscrits;

    private Double score;

    @ElementCollection
    private List<Long> keynoteIds;

    @Transient
    private List<Keynote> keynotes;

    @OneToMany(mappedBy = "conference")
    private List<Review> reviews;
}
