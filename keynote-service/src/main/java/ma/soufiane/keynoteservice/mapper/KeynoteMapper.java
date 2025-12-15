package ma.soufiane.keynoteservice.mapper;

import ma.soufiane.keynoteservice.dto.KeynoteDTO;
import ma.soufiane.keynoteservice.entity.Keynote;
import org.springframework.stereotype.Component;

@Component
public class KeynoteMapper {

    public Keynote toEntity(KeynoteDTO keynoteDTO) {
        return Keynote.builder()
                .nom(keynoteDTO.getNom())
                .prenom(keynoteDTO.getPrenom())
                .email(keynoteDTO.getEmail())
                .fonction(keynoteDTO.getFonction())
                .build();
    }

    public KeynoteDTO toDTO(Keynote keynote) {
        return KeynoteDTO.builder()
                .nom(keynote.getNom())
                .prenom(keynote.getPrenom())
                .email(keynote.getEmail())
                .fonction(keynote.getFonction())
                .build();
    }
}
