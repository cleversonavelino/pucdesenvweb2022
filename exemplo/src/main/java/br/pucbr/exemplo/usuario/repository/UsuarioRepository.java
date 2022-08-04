package br.pucbr.exemplo.usuario.repository;

import br.pucbr.exemplo.usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
}
