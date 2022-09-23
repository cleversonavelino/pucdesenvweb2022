package br.pucpr.veiculoservice.veiculo.repository;

import br.pucpr.veiculoservice.veiculo.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo,Integer> {
    Veiculo findByGuidUsuario(Integer guidUsuario);
}
