import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pessoa, RequestCreatePessoa} from './pessoa.module';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PessoaService {

  public readonly pessoaURListAll = `${environment.pessoaURListAll}`;
  public readonly PessoaURLfindNome    = `${environment.pessoaURLfindNome}`;
  public readonly PessoaURLfindCpf    = `${environment.pessoaURLfindCpf}`;
  public readonly pessoaURLfindCep    = `${environment.pessoaURLfindCep}`;
  public readonly PessoaURLfindId    = `${environment.pessoaURLInsert}`;
  public readonly PessoaURLInsert    = `${environment.pessoaURLInsert}`;

  constructor(private http: HttpClient) { }

  getPessoa(): Observable<Pessoa> {
    return this.http.get<Pessoa>(this.pessoaURListAll);
  }

  get(id) {
    return this.http.get(`${this.PessoaURLfindId}${id}`);
  }

  getPessoaNome(nome: string): Observable<any> {
    return this.http.get(`${this.PessoaURLfindNome}${nome}`);
  }

  getPessoaCpf(cpf: string): Observable<any> {
    return this.http.get(`${this.PessoaURLfindCpf}${cpf}`);
  }

  getPessoacep(cep: string): Observable<any> {
    return this.http.get(`${this.pessoaURLfindCep}${cep}`);
  }

  createPessoa(request: RequestCreatePessoa): Observable<Pessoa> {
    return this.http.post<Pessoa>(this.PessoaURLInsert, request);
  }

}
