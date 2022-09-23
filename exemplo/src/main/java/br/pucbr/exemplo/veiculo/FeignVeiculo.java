package br.pucbr.exemplo.veiculo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@FeignClient("veiculoservice")
public interface FeignVeiculo {

    //@GetMapping("/api/veiculo")
    //String testarVeiculo();

    @GetMapping("/veiculo/usuario/{id}")
    public VeiculoTo buscarPorGuidUsuario(@PathVariable("id") Integer guidUsuario);

}
