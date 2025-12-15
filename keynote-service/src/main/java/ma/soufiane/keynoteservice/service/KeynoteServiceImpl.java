package ma.soufiane.keynoteservice.service;

import lombok.AllArgsConstructor;
import ma.soufiane.keynoteservice.dto.KeynoteDTO;
import ma.soufiane.keynoteservice.entity.Keynote;
import ma.soufiane.keynoteservice.mapper.KeynoteMapper;
import ma.soufiane.keynoteservice.repository.KeynoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class KeynoteServiceImpl implements KeynoteService {
    private final KeynoteRepository keynoteRepository;
    private final KeynoteMapper keynoteMapper;

    @Override
    public Keynote getKeynoteById(Long id) {
        return keynoteRepository.findById(id).orElseThrow(() -> new RuntimeException("Keynote not found"));
    }

    @Override
    public List<Keynote> getAllKeynotes() {
        return keynoteRepository.findAll();
    }

    @Override
    public Keynote createKeynote(KeynoteDTO keynoteDTO) {
        Keynote keynote = keynoteMapper.toEntity(keynoteDTO);
        return keynoteRepository.save(keynote);
    }

    @Override
    public Keynote updateKeynote(Long id, KeynoteDTO keynoteDTO) {
        Keynote Keynote = getKeynoteById(id);
        Keynote.setNom(keynoteDTO.getNom());
        Keynote.setPrenom(keynoteDTO.getPrenom());
        Keynote.setEmail(keynoteDTO.getEmail());
        Keynote.setFonction(keynoteDTO.getFonction());
        return keynoteRepository.save(Keynote);
    }

    @Override
    public void deleteKeynote(Long id) {
        keynoteRepository.deleteById(id);
    }
}
