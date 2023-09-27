import { Component, OnInit } from '@angular/core';
import { Users } from '../users';
import { UserserviceService } from '../userservice.service';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  users: Users = new Users; 
userid=localStorage.getItem('userid');
constructor(private userservice:UserserviceService,private router:ActivatedRoute) {}
ngOnInit(): void {
  this.userservice.getUserById(this.userid).subscribe(data => {
    this.users = data;
  });
};

}
