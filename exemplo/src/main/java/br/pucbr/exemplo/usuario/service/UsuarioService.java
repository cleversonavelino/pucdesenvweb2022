package br.pucbr.exemplo.usuario.service;

import br.pucbr.exemplo.usuario.entity.Usuario;
import br.pucbr.exemplo.usuario.repository.UsuarioRepository;
import br.pucbr.exemplo.util.excecao.ExcecaoExemplo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) throws ExcecaoExemplo {
        if (usuario.getNome() == null ||
                usuario.getNome().equals("") ||
                usuario.getNome().length() > 300) {
            //lanco um erro
            throw new ExcecaoExemplo("ERR001","O dados dos usuário estão errados manow.");
        }

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(id).get();
    }

    public void excluir(Integer id) {
        usuarioRepository.deleteById(id);
    }

}
