package br.pucpr.veiculoservice.veiculo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/veiculo")
public class VeiculoController {

    @GetMapping
    public String testarVeiculo() {
        return "abc";
    }

}
