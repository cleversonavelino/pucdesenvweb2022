import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UsuarioModel } from '../model/usuario.model';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private httpClient: HttpClient) { }

  salvar(usuarioModel: UsuarioModel) {
    return this.httpClient.post<UsuarioModel>("http://localhost:8082/usuario",usuarioModel);
  }

  listar() {
    return this.httpClient.get<UsuarioModel[]>("http://localhost:8082/usuario");
  }

}
