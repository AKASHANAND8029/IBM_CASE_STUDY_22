import { Component, OnInit } from '@angular/core';
import {Task} from "../../model/task";
import {ActivatedRoute, Router} from "@angular/router";
import {TaskService} from "../../Task/TaskService/task.service";
import {User} from "../../model/user";
import {UserService} from "../UserService/user-service";

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {


  email: string ="";
  user: User | undefined;

  constructor(private route: ActivatedRoute,private router: Router,
              private userService:UserService) { }


  ngOnInit(): void {
    this.user = new User();

    this.email = this.route.snapshot.params['email'];

    this.userService.getUser(this.email)
      .subscribe(data => {
        console.log(data)
        this.user = data;
      })
  }

  list(){
    this.router.navigate(['user-list']);
  }


}
