import { Component, OnInit, Output, Input } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';
import { ProductService } from '../product.service';


@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  loginFlag=false;

  @Input() public counter;
  search : string;
  constructor(private cookie:CookieService,private route:Router) { }

  ngOnInit(): void {
    if(this.cookie.get('loginstatus')=="true")
    this.loginFlag=true;
  }
  
  logOut()
  {
     this.cookie.deleteAll();
     this.cookie.set('loginstatus','false');
     this.loginFlag=false;
     this.route.navigate([''])
  }
  searchResult()
 { 

   this.cookie.set('searchParam',this.search.toLowerCase());
   this.route.navigateByUrl('/cart', { skipLocationChange: true }).then(() => {
    this.route.navigate(['/searchresults']);
   }); 
  //  window.location.reload();
   }
 }

 
