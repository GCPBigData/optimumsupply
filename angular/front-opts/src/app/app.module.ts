import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule, LOCALE_ID } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app.routing';
import { AppComponent } from './app.component';

import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { HttpModule } from '@angular/http';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

// used to create fake backend
import { fakeBackendProvider } from './_helpers';

import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { CompanyComponent } from './company/company.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { CreateCompanyComponent } from './company/create-company/create-company.component';
import { EditCompanyComponent } from './company/edit-company/edit-company.component';

import { JwtInterceptor } from './_helpers/jwt.interceptor';
import { ErrorInterceptor } from './_helpers/error.interceptor';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';
import { LoginComponent } from './login/login.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { PessoaListComponent } from './pessoa/pessoa-list/pessoa-list.component';
import { CreatePessoaComponent } from './pessoa/create-pessoa/create-pessoa.component';
import { PessoaEditComponent } from './pessoa/pessoa-edit/pessoa-edit.component';

@NgModule({
  imports: [
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    AppRoutingModule,
    HttpModule,
    HttpClientModule,
    MatInputModule,
    MatButtonModule,
    ReactiveFormsModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    RouterModule,
  ],
  declarations: [
    AppComponent,
    AdminLayoutComponent,
    NavbarComponent,
    SidebarComponent,

    CompanyComponent,
    CreateCompanyComponent,
    EditCompanyComponent,

    HomeComponent,
    AdminComponent,
    LoginComponent,
    
    UserProfileComponent,
    
    PessoaListComponent,
    
    CreatePessoaComponent,
    
    PessoaEditComponent,
    
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
    // provider used to create fake backend
    fakeBackendProvider
  ],
  exports: [
    NavbarComponent,
    LoginComponent,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
