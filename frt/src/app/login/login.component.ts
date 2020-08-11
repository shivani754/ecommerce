import { Component, OnInit, HostListener } from '@angular/core';
import {NgForm} from '@angular/forms';
import{RegistrationService} from "../registration.service";
import { User } from '../user';
import { error } from '@angular/compiler/src/util';
import { Router } from '@angular/router';
import {DataService} from '../data.service'
import { CookieService } from 'ngx-cookie-service';
import { CartserviceService } from '../cartservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user = new User();
  message = ""; 
  
  constructor(private service : RegistrationService,private _route :Router ,private cartService:CartserviceService,private cookie:CookieService, private dataService  : DataService,private cookieService  : CookieService) { }

  ngOnInit(): void {
  }
  
  loginUser(){
         this.service.loginUserFromRemote(this.user).subscribe(
           data => {
             console.log("response, recieved");
             this.service.isLoggedIn(data.userId, data.emailId);
             this.cookieService.set('userName',data.userName );
             this.cookieService.set('phoneNumber',data.phoneNumber)
             this.service.addLoginHistory(data.userId).subscribe();
            //  this.service.addOrderHistory(data.userId).subscribe();
           if("preCart" in localStorage)
            {
              this.cartService.mergeUserNDummy(this.cookie.get('dummyUserId'),this.cookie.get('userId')).subscribe();
              localStorage.clear();

              this._route.navigateByUrl('/MyProfile', { skipLocationChange: true }).then(() => {
                this._route.navigate(['/cart']);
            }); 
             
                
              
            }
            else this._route.navigate(['']);
             
          },
           error => {
             console.log("exception Occured")
             this.message="Bad Credention. Please Enter Valid Email and Password !!"; 
            }
         )
  }
  

 

}
