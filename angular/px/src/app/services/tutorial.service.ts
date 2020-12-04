import { Injectable } from '@angular/core';
import { Tutorial } from '../models/tutorial.model';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, of, throwError } from 'rxjs';
import { tap, delay, take, map, catchError } from 'rxjs/operators';
import { environment } from '../../environments/environment';


const baseUrlCpf = 'http://localhost:9191/pessoa/v1/buscarCpf/';
const baseUrl = 'http://localhost:9191/pessoa/v1/';
const baseUrlTodos = 'http://localhost:9191/pessoa/v1/listarTodos';
const baseUrlNome = 'http://localhost:9191/pessoa/v1/buscarNome/';
const baseUrlCep = 'http://localhost:9191/pessoa/v1/buscarCep/';


const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class TutorialService {


  headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
    'Accept': 'application/json'
  });

  constructor(private http: HttpClient) { }

  getAll(): Observable<Tutorial[]> {
    return this.http.get<Tutorial[]>(baseUrlCpf);
  }

  get(id: any): Observable<Tutorial> {
    return this.http.get(`${baseUrlCpf}/${id}`);
  }

  create(data: any): Observable<any> {
    return this.http.post(baseUrlCpf, data);
  }

  update(id: any, data: any): Observable<any> {
    return this.http.put(`${baseUrlCpf}/${id}`, data);
  }

  delete(id: any): Observable<any> {
    return this.http.delete(`${baseUrlCpf}/${id}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(baseUrlCpf);
  }

  findByCpf(cpf: any): Observable<Tutorial[]> {
    return this.http.get<Tutorial[]>(`${baseUrlCpf}${cpf}`);
  }

}
