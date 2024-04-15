package br.com.ari.springaitest.phonecall;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("phone-call")
public class PhoneCallController {

    private final PhoneCallService phoneCallService;

    public PhoneCallController(PhoneCallService phoneCallService) {
        this.phoneCallService = phoneCallService;
    }

    @GetMapping("/categorize")
    public ResponseEntity<?> categorize() {
        String transcript = """
                Bom dia, meu nome é José. Não estou conseguindo acessar o app do meu banco. Quando tento entrar
                aparece a mensagem "senha inválida". Também quero saber como conseguir um empréstimo.
                """;

        return ResponseEntity.ok(phoneCallService.categorize(transcript));
    }

}
