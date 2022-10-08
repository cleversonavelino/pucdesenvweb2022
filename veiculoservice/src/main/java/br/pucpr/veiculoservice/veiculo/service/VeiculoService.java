package br.pucpr.veiculoservice.veiculo.service;

import br.pucpr.veiculoservice.producer.QueueSender;
import br.pucpr.veiculoservice.veiculo.entity.Veiculo;
import br.pucpr.veiculoservice.veiculo.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private QueueSender queueSender;

    public Veiculo salvar(Veiculo veiculo) {
        queueSender.send("guidusuario: "+veiculo.getGuidUsuario());

        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> listar() {
        return veiculoRepository.findAll();
    }

    public Veiculo buscarPorId(Integer id) {
        return veiculoRepository.findById(id).get();
    }

    public Veiculo buscarPorGuidUsuario(Integer guidUsuario) {
        return veiculoRepository.findByGuidUsuario(guidUsuario);
    }

}
