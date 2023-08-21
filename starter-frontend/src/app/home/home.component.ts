import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AuthService } from '../_services/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  
  constructor(private http:HttpClient,private authservice:AuthService){

  }
  
  ngOnInit(): void {
console.log(localStorage.getItem("access_token"));
this.callBackend()
  }

  endpoint: string = 'http://localhost:9090/';
greeting:any
  callBackend(){
    this.http.get(this.endpoint+"hello").subscribe(data=>{
      console.log(data);
      this.greeting=data
    })
  }

  logout(){
    this.authservice.doLogout();
  }
}
