import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';

import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { AuthInterceptor } from './shared/AuthInterceptor';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ProblemListComponent } from './problem-list/problem-list.component';
import { ProblemDetailsComponent } from './problem-details/problem-details.component';
import { SubmissionPageComponent } from './submission-page/submission-page.component';
import { CodemirrorModule } from '@ctrl/ngx-codemirror';
import { AdminProblemFormComponent } from './admin-problem-form/admin-problem-form.component';
import { NavbarComponent } from './navbar/navbar.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProblemListComponent,
    ProblemDetailsComponent,
    SubmissionPageComponent,
    AdminProblemFormComponent,
    NavbarComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    CodemirrorModule,

    ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
