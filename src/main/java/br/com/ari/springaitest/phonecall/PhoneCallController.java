package br.com.ari.springaitest.phonecall;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("phone-call")
public class PhoneCallController {

    private final PhoneCallService phoneCallService;

    public PhoneCallController(PhoneCallService phoneCallService) {
        this.phoneCallService = phoneCallService;
    }

    @PostMapping(value = "/categorize",
            consumes = MediaType.TEXT_PLAIN_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> categorize(@RequestBody String transcript) {
        return ResponseEntity.ok(phoneCallService.categorize(transcript));
    }

}
