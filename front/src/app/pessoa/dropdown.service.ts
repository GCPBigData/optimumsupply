import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { EstadoBr } from '../pessoa/estado-br.model';
import { Cidade } from '../pessoa/cidade';
import { map } from '../../../node_modules/rxjs/operators';
//import { map } from 'rxjs/operators';
//import 'rxjs-compat';

@Injectable()
export class DropdownService {
  constructor(private http: HttpClient) {}

  getEstadosBr() {
    return this.http.get<EstadoBr[]>('assets/dados/estadosbr.json');
  }

  getCidades(idEstado: number) {
    return this.http.get<Cidade[]>('assets/dados/cidades.json')
    .pipe(
      map((cidades: Cidade[]) => cidades.filter(c => c.estado == idEstado))
    );
  }

}
