import { Component, OnInit } from '@angular/core';
import { Tutorial } from 'src/app/models/tutorial.model';
import { TutorialService } from 'src/app/services/tutorial.service';

@Component({
  selector: 'app-add-tutorial',
  templateUrl: './add-tutorial.component.html',
  styleUrls: ['./add-tutorial.component.css']
})
export class AddTutorialComponent implements OnInit {

  tutorial: Tutorial = {
    nome: '',
    cpf: '',
    datanascimento: '',
    estado: '',
    cidade: '',
    cep: '',
    telefone: '',
    email: '',
    skype: '',
    datacadastro: '',
    status: ''
  };

  submitted = false;

  constructor(private tutorialService: TutorialService) { }

  ngOnInit(): void {
  }

  saveTutorial(): void {
    const data = {
      nome: this.tutorial.nome,
      cpf: this.tutorial.cpf
    };

    this.tutorialService.create(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }
/*
  newTutorial(): void {
    this.submitted = false;
    this.tutorial = {
      nome: '',
      cpf: '',
      datanascimento: '',
      estado: '',
      cidade: '',
      cep: '',
      telefone: '',
      email: '',
      skype: '',
      datacadastro: '',
      status: ''
    };
  }
*/
}
