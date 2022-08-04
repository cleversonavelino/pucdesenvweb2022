package br.pucbr.exemplo.usuario.controller;

import br.pucbr.exemplo.usuario.entity.Usuario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @PostMapping
    public void salvar(@RequestBody Usuario usuario) {
        System.out.println(usuario);
    }

}
