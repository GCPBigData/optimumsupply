import { Injectable } from '@angular/core';
import { CrudService } from '../shared/crud-service';
import { Pessoa } from './pessoa';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class Pessoa2Service extends CrudService<Pessoa> {

  constructor(protected http: HttpClient) {
    super(http, `${environment.pessoaURListAll}`);
  }

  loadByID(id) {
    return null;
  }
}
