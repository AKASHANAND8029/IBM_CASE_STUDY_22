import { Component, OnInit } from '@angular/core';
import {Task} from "../../model/task";
import {TaskService} from "../TaskService/task.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-update-task',
  templateUrl: './update-task.component.html',
  styleUrls: ['./update-task.component.css']
})
export class UpdateTaskComponent implements OnInit {

  uniqueTaskId: number= 0;
  // @ts-ignore
  public task: Task ;

  constructor(private route: ActivatedRoute,private router: Router,
              private taskService: TaskService) { }

  ngOnInit() {
    this.task = new Task();

    this.uniqueTaskId = this.route.snapshot.params['uniqueTaskId'];

    this.taskService.getTask(this.uniqueTaskId)
      .subscribe(data => {
        console.log(data)
        this.task = data;
      }, error => console.log(error));
  }

  updateEmployee() {
    this.taskService.updateTask(this.uniqueTaskId, this.task)
      .subscribe(data => {
        console.log(data);
        this.task = new Task();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateEmployee();
  }

  gotoList() {
    this.router.navigate(['/list']);
  }

}
