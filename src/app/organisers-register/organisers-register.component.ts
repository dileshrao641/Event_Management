import { Component } from '@angular/core';
import { Users } from '../users';
import { UserserviceService } from '../userservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-organisers-register',
  templateUrl: './organisers-register.component.html',
  styleUrls: ['./organisers-register.component.css']
})
export class OrganisersRegisterComponent {
  users:Users=new Users();
  constructor(private userservice:UserserviceService,private router:Router) {}
  onSubmit(){
   console.log(this.users);
   this.saveUser();
   }
 saveUser()
 {
 this.userservice.createUser(this.users).subscribe(data=>{
   this.goToUserList(); 
 },error=>console.log(error));
 }
 goToUserList(){
   this.router.navigate(['/organisers-login']);
   }
}
