package ma.soufiane.conferenceservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.soufiane.conferenceservice.entity.Type;

import java.time.LocalDateTime;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class ConferenceResponseDTO {
    private Long id;
    private String titre;
    private Type type;
    private LocalDateTime date;
    private Integer duree;
    private Integer nombreInscrits;
    private Double score;
    private List<Long> keynoteIds;
    private List<KeynoteDTO> keynotes;
    private List<ReviewDTO> reviews;
}
