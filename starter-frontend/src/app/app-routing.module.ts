import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { authGuard } from './shared/auth.guard';
import { ProblemListComponent } from './problem-list/problem-list.component';
import { ProblemDetailsComponent } from './problem-details/problem-details.component';
import { SubmissionPageComponent } from './submission-page/submission-page.component';
import { AdminProblemFormComponent } from './admin-problem-form/admin-problem-form.component';

const routes: Routes = [
  // { path: '', redirectTo: '/log-in', pathMatch: 'full' },
 
  { path: 'home', component: HomeComponent, 
  //canActivate: [authGuard] 
},
{ path: 'problem-list', component: ProblemListComponent },
{ path: 'problem/:id', component: ProblemDetailsComponent },
{ path: 'submit', component: SubmissionPageComponent },
{ path: 'set-problems', component: AdminProblemFormComponent },

{ path: 'log-in', component: LoginComponent },
{ path: 'register', component: RegisterComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
