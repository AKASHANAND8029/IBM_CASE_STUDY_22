import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from '../routing/app-routing.module';
import { AppComponent } from './app.component';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { TaskListComponent } from './Task/task-list/task-list.component';
import { UpdateTaskComponent } from './Task/update-task/update-task.component';
import { CreateTaskComponent } from './Task/create-task/create-task.component';
import { TaskDetailsComponent } from './Task/task-details/task-details.component';
import { CreateUserComponent } from './User/create-user/create-user.component';
import { UserListComponent } from './User/user-list/user-list.component';
import { UserDetailsComponent } from './User/user-details/user-details.component';

@NgModule({
  declarations: [
    AppComponent,
    TaskListComponent,
    UpdateTaskComponent,
    CreateTaskComponent,
    TaskDetailsComponent,
    CreateUserComponent,
    UserListComponent,
    UserDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
