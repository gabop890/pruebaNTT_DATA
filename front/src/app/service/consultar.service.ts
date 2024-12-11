import { HttpClient } from '@angular/common/http';
import { Injectable, signal } from '@angular/core';
import { Identificacion } from '../model/identificacion';
import { Observable } from 'rxjs';
import { Usuario } from '../model/usuario';

@Injectable({
  providedIn: 'root',
})
export class ConsultarService {
  urlBackend = 'http://localhost:8080';
  private data = signal(Usuario);

  constructor(private httpClient: HttpClient) {}

  consultarUsuario(value: Identificacion): Observable<Usuario> {
    return this.httpClient.post<Usuario>(this.urlBackend + '/consultar', value);
  }

  setData(update: any) {
    this.data.set(update);
  }

  getData() {
    return this.data;
  }
}
