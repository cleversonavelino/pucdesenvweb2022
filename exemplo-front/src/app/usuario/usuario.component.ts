import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {

  codigo: number = 0;
  nome: string = '';
  dataNascimento: any;

  constructor() { }

  ngOnInit(): void {
  }

  salvar() {
    console.log('codigo ' + this.codigo);
    console.log('nome ' + this.nome);
    console.log('dataNascimento ' + this.dataNascimento);
  }
}
