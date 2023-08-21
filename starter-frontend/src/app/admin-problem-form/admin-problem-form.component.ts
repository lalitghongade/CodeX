import { Component } from '@angular/core';
import { ProblemService } from '../_services/problem.service';

@Component({
  selector: 'app-admin-problem-form',
  templateUrl: './admin-problem-form.component.html',
  styleUrls: ['./admin-problem-form.component.scss']
})
export class AdminProblemFormComponent {

  problem = {
    title: '',
    description: '',
    // Add more fields here
  };

  constructor(private problemService: ProblemService) {}

  submitProblem() {
    this.problemService.submitProblem(this.problem)
      .subscribe(
        response => {
          console.log('Problem submitted successfully:', response);
          // Reset the form or navigate to a different page
        },
        error => {
          console.error('Error submitting problem:', error);
        }
      );
  }
}

