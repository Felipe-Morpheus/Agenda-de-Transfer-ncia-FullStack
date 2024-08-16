import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TransferenciaService {

  private apiUrl = 'http://localhost:8080/api/transferencias';  // URL do backend

  constructor(private http: HttpClient) { }

  getTransferencias(): Observable<any> {
    return this.http.get<any>(this.apiUrl);
  }

  // Adicione outros métodos para POST, PUT, DELETE, conforme necessário
}
