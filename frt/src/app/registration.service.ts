import { Injectable } from '@angular/core';
import {HttpClient } from '@angular/common/http';
import { User } from './user';
import { Observable } from 'rxjs';
import { CookieService } from 'ngx-cookie-service';
@Injectable({
  providedIn: 'root'
})
export class RegistrationService {
   

    

  _url= "http://localhost:8080/ecommerce/";
  constructor(private http : HttpClient, private cookie :CookieService) { }



  public loginUserFromRemote(user : User) :Observable<any>{
    
      return this.http.post<any>(this._url + "login", user); 


  }
  public registerUserFromRemote(user : User) :Observable<any>{
    
    return this.http.post<any>(this._url + "registeruser", user); 

}
  
public addLoginHistory(userId) : Observable<any>{
       
     return this.http.post<any>(this._url + "addloginrecord" , userId );
     
}
public getLoginHistory(userId)  : Observable<any>{

  return this.http.get<any>(this._url + "gethistory/"+  userId );
}

isLoggedIn(userId,email){
  
 // localStorage.setItem('loginstatus', 'true');
  this.cookie.set('userId',userId);
  this.cookie.set('email',email);
  this.cookie.set('loginstatus','true');
  
}



}
