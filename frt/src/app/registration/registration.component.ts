import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { RegistrationService } from '../registration.service';
import { Router } from '@angular/router';
import { error } from '@angular/compiler/src/util';
import {NgForm } from '@angular/forms'
import { DataService } from '../data.service';
import { CookieService } from 'ngx-cookie-service';
import { CartserviceService } from '../cartservice.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
 
  user = new User(); 
   msg='';
   
  constructor(private service : RegistrationService,private cartService : CartserviceService,private _router : Router, private cookieService : CookieService) { }
 
  userRegistration(){
     console.log("called")
      
      this.service.registerUserFromRemote(this.user).subscribe(
        data =>{
          console.log("response recieved");
          this.cookieService.set('loginstatus','true');
          this.service.isLoggedIn(data.userId,data.emailId);
          this.cookieService.set('userName',data.userName );
          this.cookieService.set('phoneNumber',data.phoneNumber)
          this.service.addLoginHistory(data.userId).subscribe();
          // this._router.navigate(['']);
          if("preCart" in localStorage)
          {
            this.cartService.mergeUserNDummy(this.cookieService.get('dummyUserId'),this.cookieService.get('userId')).subscribe();
            localStorage.clear();
            this._router.navigate(['/cart']);
          }
          else this._router.navigate(['']);
        },
        error =>{
          console.log("error occured");
          this.msg= "With this EmailId already exist";
          ;
          
        }
      )

   }



  ngOnInit(): void {
  }

}
