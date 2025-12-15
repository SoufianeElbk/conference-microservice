package ma.soufiane.keynoteservice.controller;

import lombok.AllArgsConstructor;
import ma.soufiane.keynoteservice.dto.KeynoteDTO;
import ma.soufiane.keynoteservice.entity.Keynote;
import ma.soufiane.keynoteservice.service.KeynoteService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/keynotes")
@AllArgsConstructor
public class KeynoteController {
    private final KeynoteService keynoteService;

    @GetMapping("/{id}")
    public Keynote getKeynote(@PathVariable Long id) {
        return keynoteService.getKeynoteById(id);
    }

    @GetMapping
    public List<Keynote> getAllKeynotes() {
        return keynoteService.getAllKeynotes();
    }

    @PostMapping
    public Keynote createKeynote(@RequestBody KeynoteDTO keynoteDTO) {
        return keynoteService.createKeynote(keynoteDTO);
    }

    @PutMapping("/{id}")
    public Keynote updateKeynote(@PathVariable Long id, @RequestBody KeynoteDTO keynoteDTO) {
        return keynoteService.updateKeynote(id, keynoteDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteKeynote(@PathVariable Long id) {
        keynoteService.deleteKeynote(id);
    }
}
