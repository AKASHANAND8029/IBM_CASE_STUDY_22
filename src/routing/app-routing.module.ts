import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {TaskListComponent} from "../app/Task/task-list/task-list.component";
import {UpdateTaskComponent} from "../app/Task/update-task/update-task.component";
import {CreateTaskComponent} from "../app/Task/create-task/create-task.component";
import {TaskDetailsComponent} from "../app/Task/task-details/task-details.component";
import {UserListComponent} from "../app/User/user-list/user-list.component";
import {CreateUserComponent} from "../app/User/create-user/create-user.component";
import {UserDetailsComponent} from "../app/User/user-details/user-details.component";


const routes: Routes = [
  { path: '', redirectTo: 'list', pathMatch: 'full' },
  { path: 'list', component: TaskListComponent },
  {path: 'create',component: CreateTaskComponent},
  { path: 'find/:uniqueTaskId', component: TaskDetailsComponent },
  { path: 'update/:uniqueTaskId', component: UpdateTaskComponent},
  { path: 'user-list', component: UserListComponent },
  {path: 'user-create',component: CreateUserComponent},
  { path: 'user-find/:email', component: UserDetailsComponent}];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
