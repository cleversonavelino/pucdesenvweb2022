package br.pucbr.exemplo.sender;

import br.pucbr.exemplo.usuario.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teste-mq")
public class TesteMQController {

    @Autowired
    QueueSender queueSender;

    @GetMapping
    public void testar() {
        queueSender.send("teste de envio de mensagem...");
    }

}
