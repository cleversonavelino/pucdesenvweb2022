package br.pucbr.exemplo.veiculo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@FeignClient(name="veiculoService", url = "http://localhost:8081")
public interface FeignVeiculo {

    @GetMapping("/veiculo/usuario/{id}")
    public VeiculoTo buscarPorGuidUsuario(@PathVariable("id") Integer guidUsuario);

}
