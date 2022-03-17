import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})

export class UserService {
  private baseUrl = "http://localhost:9091";
  private baseUrl1 = "http://localhost:9091/user-create";
  private deleteUrl = "http://localhost:9091/user-delete";
  private findUrl = "http://localhost:9091/user-find";

  constructor(private http: HttpClient) { }

  getUsersList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/user-list`);
  }

  createUser(user: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl1}`, user);
  }

  getUser(email:string): Observable<any> {
    return this.http.get(`${this.findUrl}/${email}`);
  }

  deleteUser(email:string): Observable<any> {
    return this.http.delete(`${this.deleteUrl}/${email}`);
  }

  // updateTask(id:number, value:any) : Observable<Object> {
  //   return this.http.put(`${this.baseUrl}/update/${id}`,value);
  // }
}
