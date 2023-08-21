import { Component } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../_services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

  signupForm: FormGroup;
  constructor(
    public fb: FormBuilder,
    public authService: AuthService,
    public router: Router
  ) {
    this.signupForm = this.fb.group({
      name: [''],
      email: [''],
      mobile: [''],
      password: [''],
    });
  }
  ngOnInit() {}
  registerUser() {
    this.authService.signUp(this.signupForm.value).subscribe((res) => {
      if (res) {
        this.signupForm.reset();
        this.router.navigate(['log-in']);
      }
    });
  }
}
