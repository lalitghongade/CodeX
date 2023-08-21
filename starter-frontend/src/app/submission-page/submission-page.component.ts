import { Component } from '@angular/core';

@Component({
  selector: 'app-submission-page',
  templateUrl: './submission-page.component.html',
  styleUrls: ['./submission-page.component.scss']
})
export class SubmissionPageComponent {
  selectedLanguage: string = 'cpp'; // Default selected language
  outputMessage: string = '';

  code: string = `// Start typing your code here...`;
  
  editorConfig = {
    lineNumbers: true,
    mode: 'javascript',
    theme: 'material'
  };

  compileAndRun() {
    // Implement the logic to compile/interpret and run the code
    // Set the outputMessage based on the output/error
  }

  submitSolution() {
    // Implement the logic to submit the code for evaluation
  }
}
