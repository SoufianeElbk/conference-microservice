package ma.soufiane.conferenceservice.service;

import lombok.AllArgsConstructor;
import ma.soufiane.conferenceservice.dto.ConferenceResponseDTO;
import ma.soufiane.conferenceservice.entity.Conference;
import ma.soufiane.conferenceservice.mapper.ConferenceMapper;
import ma.soufiane.conferenceservice.repository.ConferenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConferenceServiceImpl implements ConferenceService {
    private final ConferenceRepository conferenceRepository;
    private final ConferenceMapper conferenceMapper;

    @Override
    public Conference getConferenceById(Long id) {
        return conferenceRepository.findById(id).orElseThrow(() -> new RuntimeException("Conference not found"));
    }

    @Override
    public List<Conference> getAllConferences() {
        return conferenceRepository.findAll();
    }

    @Override
    public Conference saveConference(ConferenceResponseDTO conferenceResponseDTO) {
        Conference conference = conferenceMapper.toEntity(conferenceResponseDTO);
        return  conferenceRepository.save(conference);
    }

    @Override
    public Conference updateConference(ConferenceResponseDTO conferenceResponseDTO) {
        return null;
    }

    @Override
    public void deleteConference(Long id) {

    }
}
