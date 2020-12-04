import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Resolve } from '@angular/router';
import { Observable, of } from 'rxjs';
import { Pessoa } from '../pessoa';
import { PessoaService } from '../../pessoa/pessoa.service';

@Injectable({
  providedIn: 'root'
})
export class PessoaResolverGuard implements Resolve<Pessoa> {
  constructor(private service: PessoaService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Pessoa> {
    if (route.params && route.params['id']) {
      return this.service.loadByID(route.params['id']);
    }

    return of({
      id: null,
      nome: null,
      cpf: null,
      datanascimento: null,
      estado: null,
      cidade: null,
      cep: null,
      telefone: null,
      email: null,
      skype: null,
      datacadastro: null,
      status: null
    });
  }
}
