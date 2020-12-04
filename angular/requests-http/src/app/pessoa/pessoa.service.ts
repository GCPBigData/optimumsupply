import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Pessoa } from './pessoa';
import { tap, delay, take } from 'rxjs/operators';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PessoaService {

  private readonly baseUrl = `${environment.baseUrl}`;
  private readonly pessoaURLfindCpf = `${environment.pessoaURLfindCpf}`;
  private readonly pessoaURListAll = `${environment.pessoaURListAll}`;

  constructor(private http: HttpClient) { }

  list() {
    return this.http.get<Pessoa[]>(this.pessoaURListAll)
      .pipe(
        delay(2000),
        tap(console.log)
      );
  }

  getPessoaCpf(cpf: string): Observable<any> {
    return this.http.get(`${this.pessoaURLfindCpf}${cpf}`);
  }

  loadByID(id) {
    return this.http.get<Pessoa>(`${this.baseUrl}/${id}`).pipe(take(1));
  }
  loadByCpf(cpf) {
    return this.http.get<Pessoa>(`${this.pessoaURLfindCpf}${cpf}`);
  }

  private create(Pessoa) {
    return this.http.post(this.baseUrl, Pessoa).pipe(take(1));
  }

  private update(Pessoa) {
    return this.http.put(`${this.baseUrl}/${Pessoa.id}`, Pessoa).pipe(take(1));
  }

  save(Pessoa) {
    if (Pessoa.id) {
      return this.update(Pessoa);
    }
    return this.create(Pessoa);
  }

}
