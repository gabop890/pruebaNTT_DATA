import { HttpClient } from '@angular/common/http';
import { Injectable, signal } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../model/usuario';

@Injectable({
  providedIn: 'root',
})
export class ConsultarService {
  urlBackend = 'http://localhost:8090';
  private data!: Usuario;

  constructor(private httpClient: HttpClient) {}

  consultarUsuario(value: any): Observable<Usuario> {
    return this.httpClient.post<Usuario>(this.urlBackend + '/consultar', value);
  }

  setData(update: any) {
    this.data = update;
  }

  getData() {
    return this.data;
  }
}
