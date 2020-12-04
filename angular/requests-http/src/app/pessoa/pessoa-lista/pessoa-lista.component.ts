import { Component, OnInit, ViewChild } from '@angular/core';
import { PessoaService } from '../pessoa.service';
import { Pessoa } from '../pessoa';
import { Observable, empty, of, Subject, EMPTY } from 'rxjs';
import { catchError, switchMap, take } from 'rxjs/operators';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { AlertModalComponent } from '../../shared/alert-modal/alert-modal.component';
import { AlertModalService } from '../../shared/alert-modal.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Pessoa2Service } from '../../pessoa/pessoa2.service';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { tap, map, filter, distinctUntilChanged, debounceTime } from 'rxjs/operators';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-pessoa-lista',
  templateUrl: './pessoa-lista.component.html',
  styleUrls: ['./pessoa-lista.component.scss'],
  preserveWhitespaces: true
})
export class PessoaListaComponent implements OnInit {

  deleteModalRef: BsModalRef;
  @ViewChild('deleteModal', { static: true }) deleteModal;

  pessoa$: Observable<Pessoa[]>;
  error$ = new Subject<boolean>();

  cursoSelecionado: Pessoa;

  queryField = new FormControl();
  readonly SEARCH_URL = 'https://api.cdnjs.com/libraries';
  results$: Observable<any>;
  total: number;
  readonly FIELDS = 'name,description,version,homepage';

  constructor(
    private service: Pessoa2Service,
    private pessoaService: PessoaService,
    private modalservice: BsModalService,
    private alertService: AlertModalService,
    private router: Router,
    private route: ActivatedRoute,
    private http: HttpClient
  ) {}

  ngOnInit() {
    this.onRefresh();
  }

  onRefresh() {
    this.pessoa$ = this.service.list().pipe(
      catchError(error => {
        console.error(error);
        this.handleError();
        return empty();
      })
    );

  }

  handleError() {
    this.alertService.showAlertDanger('Erro ao carregar pessoa. Tente novamente mais tarde.');
    }

  onEdit(id) {
    this.router.navigate(['editar', id], { relativeTo: this.route });
  }

  onDelete(curso) {
    this.cursoSelecionado = curso;
    // this.deleteModalRef = this.modalService.show(this.deleteModal, { class: 'modal-sm' });

    const result$ = this.alertService.showConfirm('Confirmacao', 'Tem certeza que deseja remover esse curso?');
    result$.asObservable()
    .pipe(
      take(1),
      switchMap(result => result ? this.service.remove(curso.id) : EMPTY)
    )
    .subscribe(
      success => {
        this.onRefresh();
      },
      error => {
        this.alertService.showAlertDanger('Erro ao remover curso. Tente novamente mais tarde.');
      }
    );
  }

  onConfirmDelete() {
    this.service.remove(this.cursoSelecionado.id)
    .subscribe(
      success => {
        this.onRefresh();
        this.deleteModalRef.hide();
      },
      error => {
        this.alertService.showAlertDanger('Erro ao remover curso. Tente novamente mais tarde.');
        this.deleteModalRef.hide();
      }
    );
  }

  onDeclineDelete() {
    this.deleteModalRef.hide();
  }

  onSearchCpf= () => {
      let value = this.queryField.value;
      if (value && (value = value.trim()) !== '') {
        this.results$ = this.http.get(this.pessoaService.getPessoaCpf + value)
            .pipe(
                tap((res: string) => res),
                map((res: string) => res)
            );
    };
  }


}
