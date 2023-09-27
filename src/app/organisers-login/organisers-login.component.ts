import { Component } from '@angular/core';
import { Users } from '../users';
import { UserserviceService } from '../userservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-organisers-login',
  templateUrl: './organisers-login.component.html',
  styleUrls: ['./organisers-login.component.css']
})
export class OrganisersLoginComponent {
  model:any={};
  getData:any;
 users:Users=new Users();
  constructor(private userservice:UserserviceService,private router:Router ){}
loginUser(){
  const emailId=this.model.emailId;
  const password=this.model.password;
  this.userservice.getUserData(emailId,password).subscribe((data:any)=>{
    this.getData=data as boolean;
    if(this.getData==true)
    {
      this.userservice.getUserId(emailId).subscribe(data=>{
        localStorage.setItem('userid',data.toString());
        console.log(localStorage.getItem('userid'));
      })
        // this.userservice.getUserName(emailId).subscribe(data=>{
        //   localStorage.setItem("name",data.toString());
        //   console.log(localStorage.getItem("name"));
        this.userservice.getUserName(emailId).subscribe(
          data => {
            localStorage.setItem('name', data.name.toString()); // St9ore the plain string in localStorage
            console.log(localStorage.getItem('name'));
          },
          error => {
            console.error('Error:', error);
          }
        );
        
      this.router.navigate(["/organisers-dashboard"]);
    }
    else{
      alert("Invalid Email or Password");
    }
  });
}
}

