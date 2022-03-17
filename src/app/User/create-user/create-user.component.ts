import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {User} from "../../model/user";
import {UserService} from "../UserService/user-service";
import {RoleType} from "../../model/role-type";

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {

  user : User = new User();
  submitted=false;

  constructor(private userService: UserService, private router: Router) {
  }

  ngOnInit(): void {
  }

  save() {
      if(this.user.userRole=="ADMIN"){
        this.user.userRole=RoleType.Admin;
      }else if(this.user.userRole=="MANAGER"){
        this.user.userRole=RoleType.Manager;
      }else if(this.user.userRole=="USER"){
        this.user.userRole=RoleType.User;
      }
    this.userService.createUser(this.user).subscribe(data => {
        this.user = new User();
        this.gotoList();
      },
      error => console.log(error));
  }

  public gotoList() {
    this.router.navigate(['user-list']);

  }

  onSubmit() {
    this.submitted=true;
    this.save();
  }


}
