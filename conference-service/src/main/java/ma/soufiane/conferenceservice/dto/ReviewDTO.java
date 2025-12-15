package ma.soufiane.conferenceservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class ReviewDTO {
    private LocalDate date;
    private String commentaire;
    private Integer note;
    private Long conferenceId;
}
