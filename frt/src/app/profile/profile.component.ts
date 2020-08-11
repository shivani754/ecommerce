import { Component, OnInit } from '@angular/core';
import {DataService} from '../data.service'
import { User } from '../user';
import { CookieService } from 'ngx-cookie-service';
import { RegistrationService } from '../registration.service';
import { CartserviceService } from '../cartservice.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  
  // user : any ;
  public date=new Date();
   email : any;
   phoneNumber : any;
   name: any;
   orderHistoryData:any;
   loginHistroydata : any;

  constructor(private dataService  :  DataService,private cookieService : CookieService ,private cartService:CartserviceService, private loginService : RegistrationService) { }
  
  ngOnInit(): void {
       this.name = this.cookieService.get('userName');
       this.email= this.cookieService.get('email');
       this.phoneNumber= this.cookieService.get('phoneNumber');
      
  }
  loginHistory(){
      
    this.loginService.getLoginHistory(this.cookieService.get('userId')).subscribe(
      data=>{
           this.loginHistroydata = data;
           console.log(this.loginHistroydata)
      }
    )
    
  }
  orderHistory(){
    this.cartService.orderHistory(this.cookieService.get('userId')).subscribe(
      data=>{
        this.orderHistoryData=data;
        console.log(this.orderHistoryData);
      }
    )
  }

}
