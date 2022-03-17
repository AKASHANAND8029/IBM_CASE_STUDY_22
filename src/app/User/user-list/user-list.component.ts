import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {Task} from "../../model/task";
import {TaskService} from "../../Task/TaskService/task.service";
import {Router} from "@angular/router";
import {UserService} from "../UserService/user-service";
import {User} from "../../model/user";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  user: Observable<User[]> | undefined;
  constructor(private userService : UserService, private router:Router) {}

  ngOnInit(): void {
    this.reloadData();
  }
  private reloadData() {
    this.user = this.userService.getUsersList();
  }

  deleteUser(email:string) {
    this.userService.deleteUser(email).subscribe(data => {
      console.log(data);
      this.reloadData();
    }, error => console.log(error));
  }

  // updateTask(uniqueTaskId: number) {
  //   this.router.navigate(['/update',uniqueTaskId]);
  // }

 getUser(email:string)
  {
    this.router.navigate(['user-find', email]);
  }

}
