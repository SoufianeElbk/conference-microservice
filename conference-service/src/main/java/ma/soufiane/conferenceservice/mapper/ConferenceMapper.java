package ma.soufiane.conferenceservice.mapper;

import lombok.AllArgsConstructor;
import ma.soufiane.conferenceservice.dto.ConferenceResponseDTO;
import ma.soufiane.conferenceservice.entity.Conference;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ConferenceMapper {

    private final ReviewMapper reviewMapper;

    public Conference toEntity(ConferenceResponseDTO conferenceResponseDTO) {
        Conference conference = new Conference();
        conference.setId(conferenceResponseDTO.getId());
        conference.setTitre(conferenceResponseDTO.getTitre());
        conference.setDate(conferenceResponseDTO.getDate());
        conference.setDuree(conferenceResponseDTO.getDuree());
        conference.setNombreInscrits(conferenceResponseDTO.getNombreInscrits());
        conference.setReviews(conferenceResponseDTO.getReviews().stream().map(reviewMapper::toEntity).toList());
        conference.setKeynotes(conferenceResponseDTO.getKeynotes());
        conference.setKeynoteIds(conferenceResponseDTO.getKeynoteIds());
        return conference;
    }

    public ConferenceResponseDTO toDTO(Conference conference) {
        ConferenceResponseDTO conferenceResponseDTO = new ConferenceResponseDTO();
        conferenceResponseDTO.setId(conference.getId());
        conferenceResponseDTO.setTitre(conference.getTitre());
        conferenceResponseDTO.setDate(conference.getDate());
        conferenceResponseDTO.setDuree(conference.getDuree());
        conferenceResponseDTO.setNombreInscrits(conference.getNombreInscrits());
        conferenceResponseDTO.setKeynotes(conference.getKeynotes());
        conferenceResponseDTO.setReviews(conference.getReviews().stream().map(reviewMapper::toDTO).toList());
        return conferenceResponseDTO;
    }
}
