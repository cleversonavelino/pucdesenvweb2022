import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UsuarioModel } from '../model/usuario.model';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private httpClient: HttpClient) { }

  salvar(usuarioModel: UsuarioModel) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        Authorization: 'Bearer ' + localStorage.getItem('token')
      })
    };
    return this.httpClient.
    post<UsuarioModel>("http://localhost:8082/usuario",usuarioModel, httpOptions);
  }

  listar() {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        Authorization: 'Bearer ' + localStorage.getItem('token')
      })
    };
    return this.httpClient.get<UsuarioModel[]>("http://localhost:8082/usuario",httpOptions);
  }

}
