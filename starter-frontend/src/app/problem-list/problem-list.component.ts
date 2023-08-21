import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-problem-list',
  templateUrl: './problem-list.component.html',
  styleUrls: ['./problem-list.component.scss']
})
export class ProblemListComponent {

  problems: any[] = [
    {
      id: 1,
      title: 'Problem 1',
      difficulty: 'Easy',
      description: 'Description of Problem 1'
    },
    {
      id: 2,
      title: 'Problem 2',
      difficulty: 'Medium',
      description: 'Description of Problem 2'
    },
    // Add more problems
  ];

  constructor(private router: Router) {}

  submitSolution(problemId: number) {
    // Implement the logic for submitting a solution
    // For example, navigate to the problem details page
    this.router.navigate(['/problem', problemId]);
  }

}
