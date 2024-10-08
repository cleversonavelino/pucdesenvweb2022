package br.pucpr.veiculoservice.producer;

import br.pucpr.veiculoservice.veiculo.entity.Veiculo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class RequestProducer {

    @Value("puc-2024")
    private String topicoRequest;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    public String sendMessage(Veiculo veiculo) throws JsonProcessingException {
        String orderAsMessage = objectMapper.writeValueAsString(veiculo);
        kafkaTemplate.send(topicoRequest, orderAsMessage);
        return "veiculo enviado";
    }
}
