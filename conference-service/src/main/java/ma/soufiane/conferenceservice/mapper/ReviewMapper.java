package ma.soufiane.conferenceservice.mapper;

import lombok.AllArgsConstructor;
import ma.soufiane.conferenceservice.dto.ReviewDTO;
import ma.soufiane.conferenceservice.entity.Review;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReviewMapper {
    private final ConferenceMapper conferenceMapper;
    public Review toEntity(ReviewDTO reviewDTO) {
        Review review = new Review();
        review.setId(reviewDTO.getId());
        review.setCommentaire(reviewDTO.getCommentaire());
        review.setDate(reviewDTO.getDate());
        review.setNote(reviewDTO.getNote());
        review.setConference(conferenceMapper.toEntity(reviewDTO.getConferenceDTO()));
        return review;
    }

    public ReviewDTO toDTO(Review review) {
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setId(review.getId());
        reviewDTO.setCommentaire(review.getCommentaire());
        reviewDTO.setDate(review.getDate());
        reviewDTO.setNote(review.getNote());
        reviewDTO.setConferenceDTO(conferenceMapper.toDTO(review.getConference()));
        return reviewDTO;


    }
}
