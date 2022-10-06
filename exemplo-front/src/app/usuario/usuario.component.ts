import { Component, OnInit } from '@angular/core';
import { UsuarioModel } from './model/usuario.model';
import { UsuarioService } from './service/usuario.service';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {

  id: number = 0;
  nome: string = '';
  login: string = '';;
  senha: string = '';;

  constructor(private usuarioService: UsuarioService) { }

  ngOnInit(): void {
  }

  salvar() {
    console.log('id ' + this.id);
    console.log('nome ' + this.nome);
    console.log('login ' + this.login);
    console.log('senha ' + this.senha);

    let usuario = new UsuarioModel();
    usuario.id = this.id;
    usuario.nome = this.nome;
    usuario.login = this.login;
    usuario.senha = this.senha;

    this.usuarioService.salvar(usuario).subscribe(usuarioRetorno => {
      console.log('funcionou');
    }, err => {
      console.log(err);
    });
  }

  listar() {
    this.usuarioService.listar().subscribe(usuarios => {
      console.log(usuarios);
    });
  }
}
