package ma.soufiane.conferenceservice.controller;

import lombok.AllArgsConstructor;
import ma.soufiane.conferenceservice.service.ConferenceService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ConferenceController {
    private final ConferenceService conferenceService;
}
