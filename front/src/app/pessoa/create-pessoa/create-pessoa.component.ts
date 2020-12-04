import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormControl, FormGroupDirective, FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';
import { RequestCreatePessoa } from '../pessoa.model';
import { PessoasService } from '../pessoa.service';
import { HttpClient } from '@angular/common/http';
import { Observable, empty } from 'rxjs';
import { map, tap, distinctUntilChanged, switchMap } from 'rxjs/operators';
import { HostListener, ViewChild } from '@angular/core';
import { BsDatepickerDirective } from 'ngx-bootstrap/datepicker';
import { componentFactoryName } from '@angular/compiler';
import { ConsultaCepService } from '../consulta.cep.service';
import { EstadoBr } from '../estado-br.model';
import { Cidade } from '../cidade';
import { FormValidations } from 'app/shared/form-validations';
import { CpfValidator } from '../../shared/cpf.validator';

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

declare var $: any;

@Component({
  selector: 'app-create-pessoa',
  templateUrl: './create-pessoa.component.html',
  styleUrls: ['./create-pessoa.component.css']
})
export class CreatePessoaComponent implements OnInit {

  //CEP Estado Cidade
  estados: EstadoBr[];
  cidades: Cidade[];

  //Calendario
  @ViewChild(BsDatepickerDirective, { static: false }) datepicker: BsDatepickerDirective;
  @HostListener('window:scroll')
  onScrollEvent() {
    this.datepicker.hide();
  }

  pessoaForm: FormGroup;
  showSpinner = false;
  statusString: string[] = ['Ativo' , 'Inativo'];

  request: RequestCreatePessoa = {
    nome               : '',
    cpf                : '',
    datanascimento     : '',
    estado             : '',
    cidade             : '',
    cep                : '',
    telefone           : '',
    email              : '',
    skype              : '',
    datacadastro       : '',
    status             : 'Ativo',
    
  }

  constructor(private pessoasService: PessoasService,
              private cepService: ConsultaCepService, 
              private http: HttpClient,
              private formBuilder: FormBuilder,
              private router: Router
              ) {

  }

  getEstadosBr() {
    return this.http.get<EstadoBr[]>('assets/dados/estadosbr.json');
  }

  getCidades(idEstado: number) {
    return this.http.get<Cidade[]>('assets/dados/cidades.json')
    .pipe(
      map((cidades: Cidade[]) => cidades.filter(c => c.estado == idEstado))
    );
  }

  gerarForm() {
    this.pessoaForm = this.formBuilder.group({

      nome                : [null],
      cpf: ['', [Validators.required, CpfValidator]],
      datanascimento     : [null],
      estado             : [null],
      cidade             : [null],
      cep: [null, [Validators.required, FormValidations.cepValidator]],
      telefone           : [null],
      email              : [null],
      skype              : [null],
      datacadastro       : [null],
      status             : 'Ativo'
    });

    this.pessoaForm.get('endereco.cep').statusChanges
    .pipe(
      distinctUntilChanged(),
      tap(value => console.log('status CEP:', value)),
      switchMap(status => status === 'VALID' ?
        this.cepService.consultaCEP(this.pessoaForm.get('endereco.cep').value)
        : empty()
      )
    )
    .subscribe(dados => dados ? this.populaDadosForm(dados) : {});

    this.pessoaForm.get('endereco.estado').valueChanges
      .pipe(
        tap(estado => console.log('Novo estado: ', estado)),
        map(estado => this.estados.filter(e => e.sigla === estado)),
        map(estados => estados && estados.length > 0 ? estados[0].id : empty()),
        switchMap((estadoId: number) => this.getCidades(estadoId)),
        tap(console.log)
      )
      .subscribe(cidades => this.cidades = cidades);

  }

  ngOnInit() {
   this.gerarForm();
   this.showSpinner = true;
 }

  save() {
    this.pessoasService.createPessoa(this.request)
        .subscribe(
            data => {
              this.showNotificationSucesso();
              this.limpa();
            },
            err => {
              this.showNotificationErro();
            })
  }

  consultaCEP() {
    const cep = this.pessoaForm.get('request.cep').value;
    if (cep != null && cep !== '') {
      this.cepService.consultaCEP(cep)
      .subscribe(dados => this.populaDadosForm(dados));
    }
  }

  populaDadosForm(dados) {
    this.pessoaForm.patchValue({
      endereco: {
        rua: dados.logradouro,
        complemento: dados.complemento,
        bairro: dados.bairro,
        cidade: dados.localidade,
        estado: dados.uf
      }
    });
   }

  limpa() {
    this.pessoaForm.reset();
  }

  showNotificationSucesso() {

    const type = ['', 'info', 'success', 'warning', 'danger'];
    const color = Math.floor((Math.random() * 4) + 1);

    $.notify({
      icon: 'notifications',
      message: 'Salvo com Suceso !<b></b>'
    }, {
      type: type[color],
      timer: 2000,
      placement: {},
      template: '<div data-notify="container" class="col-xl-4 col-lg-4 col-11 col-sm-4 col-md-4 alert alert-{0} alert-with-icon" role="alert">' +
          '<button mat-button  type="button" aria-hidden="true" class="close mat-button" data-notify="dismiss">  <i class="material-icons">close</i></button>' +
          '<i class="material-icons" data-notify="icon">notifications</i> ' +
          '<span data-notify="title">{1}</span> ' +
          '<span data-notify="message">{2}</span>' +
          '<div class="progress" data-notify="progressbar">' +
          '<div class="progress-bar progress-bar-{0}" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%;"></div>' +
          '</div>' +
          '<a href="{3}" target="{4}" data-notify="url"></a>' +
          '</div>'
    });
  }

  showNotificationErro() {

    const type = ['', 'info', 'success', 'warning', 'danger'];
    const color = Math.floor((Math.random() * 4) + 1);

    $.notify({
      icon: 'notifications',
      message: 'Servidor Retornou ERRO !<b></b>'
    }, {
      type: type[color],
      timer: 2000,
      placement: {},
      template: '<div data-notify="container" class="col-xl-4 col-lg-4 col-11 col-sm-4 col-md-4 alert alert-{0} alert-with-icon" role="alert">' +
          '<button mat-button  type="button" aria-hidden="true" class="close mat-button" data-notify="dismiss">  <i class="material-icons">close</i></button>' +
          '<i class="material-icons" data-notify="icon">notifications</i> ' +
          '<span data-notify="title">{1}</span> ' +
          '<span data-notify="message">{2}</span>' +
          '<div class="progress" data-notify="progressbar">' +
          '<div class="progress-bar progress-bar-{0}" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%;"></div>' +
          '</div>' +
          '<a href="{3}" target="{4}" data-notify="url"></a>' +
          '</div>'
    });
  }
}

