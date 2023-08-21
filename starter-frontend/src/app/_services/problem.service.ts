import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProblemService {
  private baseUrl = 'http://localhost:9090'; // Replace with your API URL

  constructor(private http: HttpClient) {}

  submitProblem(problem: any): Observable<any> {
    const url = `${this.baseUrl}/admin/problems`;
    return this.http.post(url, problem);
  }

}
