
import {RoleType} from "./role-type";

export class User {

  public userId:number=0;
  public userName: string | undefined;
  public email: string="";
  public encryptedPassword:string | undefined;
  public userRole:RoleType | undefined;
  //public actions: boolean | undefined;
}
