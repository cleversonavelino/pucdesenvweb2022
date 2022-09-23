package br.pucpr.veiculoservice.veiculo.controller;

import br.pucpr.veiculoservice.veiculo.entity.Veiculo;
import br.pucpr.veiculoservice.veiculo.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public Veiculo salvar(@RequestBody Veiculo veiculo) {
        return veiculoService.salvar(veiculo);
    }

    @GetMapping
    public List<Veiculo> listar() {
        return veiculoService.listar();
    }

    @GetMapping("/{id}")
    public Veiculo buscarPorId(@PathVariable("id") Integer id) {
        return veiculoService.buscarPorId(id);
    }

    @GetMapping("/usuario/{id}")
    public Veiculo buscarPorGuidUsuario(@PathVariable("id") Integer guidUsuario) {
        return veiculoService.buscarPorGuidUsuario(guidUsuario);
    }
}
