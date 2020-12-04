import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, of, throwError } from 'rxjs';
import { tap, delay, take, map, catchError } from 'rxjs/operators';
import {Pessoa, RequestCreatePessoa} from './pessoa.model';
import { environment } from '../../environments/environment';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class PessoasService {

  public readonly pessoaURListAll = `${environment.pessoaURListAll}`;
  public readonly PessoaURLfindNome    = `${environment.pessoaURLfindNome}`;
  public readonly PessoaURLfindCpf    = `${environment.pessoaURLfindCpf}`;
  public readonly pessoaURLfindCep    = `${environment.pessoaURLfindCep}`;
  public readonly PessoaURLfindId    = `${environment.pessoaURLInsert}`;
  public readonly PessoaURLInsert    = `${environment.pessoaURLInsert}`;
  public readonly pessoaURLUpdate    = `${environment.pessoaURLUpdate}`;

  headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
    'Accept': 'application/json'
  });

  constructor(private http: HttpClient) { }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }

  getPessoaid(id: number): Observable<any> {
    return this.http.get(`${this.PessoaURLfindId}${id}`);
  }

  getPessoas(): Observable<Pessoa> {
    return this.http.get<Pessoa>(this.pessoaURListAll);
  }

  createPessoa(request: RequestCreatePessoa): Observable<Pessoa> {
    return this.http.post<Pessoa>(this.PessoaURLInsert, request);
  }

  update(id, data) {
    return this.http.put(`${this.pessoaURLUpdate}/${id}`, data);
  }

  updatePessoa(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.pessoaURLUpdate}${id}`, value);
 }

  searchPessoaName(nome: string) {
    return this.http.get<Pessoa[]>(this.PessoaURLfindNome + nome)
        .pipe(
            delay(1000),
            tap(console.log),
            catchError((err, caught) => err)
        );
  }

  getPessoaName(nome: string): Observable<any> {
    return this.http.get(`${this.PessoaURLfindNome}${nome}`);
  }

  getPessoaCpf(cpf: string): Observable<any> {
    return this.http.get(`${this.PessoaURLfindCpf}${cpf}`);
  }

  getPessoaCep(cep: string): Observable<any> {
    return this.http.get(`${this.pessoaURLfindCep}${cep}`);
  }

}
