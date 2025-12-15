package ma.soufiane.keynoteservice.service;

import ma.soufiane.keynoteservice.dto.KeynoteDTO;
import ma.soufiane.keynoteservice.entity.Keynote;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KeynoteService {
    Keynote getKeynoteById(Long id);
    List<Keynote> getAllKeynotes();
    Keynote createKeynote(KeynoteDTO keynoteDTO);
    Keynote updateKeynote(Long id, KeynoteDTO keynoteDTO);
    void deleteKeynote(Long id);
}
