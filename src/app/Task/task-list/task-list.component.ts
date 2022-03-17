import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {Task} from "../../model/task";
import {TaskService} from "../TaskService/task.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {
  task: Observable<Task[]> | undefined;
  constructor(private taskService: TaskService, private router:Router) {}

  ngOnInit(): void {
    this.reloadData();
  }
  private reloadData() {
    this.task = this.taskService.getTaskList();
  }

  deleteTask(uniqueTaskId: number) {
    this.taskService.deleteTask(uniqueTaskId).subscribe(data => {
      console.log(data);
      this.reloadData();
    }, error => console.log(error));
  }

  updateTask(uniqueTaskId: number) {
    this.router.navigate(['/update',uniqueTaskId]);
  }

  taskDetails(uniqueTaskId:number)
  {
    this.router.navigate(['/find', uniqueTaskId]);
  }
}
