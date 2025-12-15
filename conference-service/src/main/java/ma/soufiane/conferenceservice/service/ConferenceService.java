package ma.soufiane.conferenceservice.service;

import ma.soufiane.conferenceservice.dto.ConferenceResponseDTO;
import ma.soufiane.conferenceservice.entity.Conference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConferenceService {
    Conference getConferenceById(Long id);
    List<Conference> getAllConferences();
    Conference saveConference(ConferenceResponseDTO conferenceResponseDTO);
    Conference updateConference(ConferenceResponseDTO conferenceResponseDTO);
    void deleteConference(Long id);
}
