import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PessoaListCpfComponent } from './pessoa-list-cpf.component';

describe('PessoaListCpfComponent', () => {
  let component: PessoaListCpfComponent;
  let fixture: ComponentFixture<PessoaListCpfComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PessoaListCpfComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PessoaListCpfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
