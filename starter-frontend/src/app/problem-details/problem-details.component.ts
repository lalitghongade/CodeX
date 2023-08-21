import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-problem-details',
  templateUrl: './problem-details.component.html',
  styleUrls: ['./problem-details.component.scss']
})
export class ProblemDetailsComponent {
  problem: any = {
    id: 1,
    title: 'Problem 1',
    difficulty: 'Easy',
    fullStatement: 'Full problem statement...',
    examples: [
      { input: 'Input 1', output: 'Output 1' },
      { input: 'Input 2', output: 'Output 2' },
      // Add more examples
    ],
    constraints: 'Problem constraints...'
  };

  constructor(private route: ActivatedRoute) {
    // Fetch problem details based on the route parameter (problem ID)
    const problemId = this.route.snapshot.params['id'];
    // You can implement logic to fetch problem details from a service or database
  }

  submitCode() {
    // Implement the logic for submitting code
  }
}
