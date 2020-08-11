import { Component, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { CartserviceService } from '../cartservice.service';




@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
 
mobiles:Product[]=[];
bottles:Product[]=[];
proteins:Product[]=[];
pens:Product[]=[];
watches:Product[]=[];
  search : string ;
  constructor(private cookie:CookieService, private productservice : ProductService,private cartService :CartserviceService) { }

  ngOnInit(): void {
     this.productservice.mobileProducts().subscribe((data:Product[])=>
     {
       for(let i=0;i<5;i++)
       this.mobiles.push(data[i]);
     })
     this.productservice.watchProducts().subscribe((data : Product[])=>{
      for(let i=0;i<5;i++)
       this.watches.push(data[i])
      });
     this.productservice.pensProducts().subscribe((data :Product[])=>{
      for(let i=0;i<5;i++)
       this.pens.push(data[i])}
       );
     this.productservice.proteinProducts().subscribe((data :Product[])=>{
      for(let i=0;i<5;i++)
       this.proteins.push(data[i])}
       );
     this.productservice.bottleProducts().subscribe((data : Product[])=>{
      for(let i=0;i<5;i++)
       this.bottles.push(data[i])}
       
       );
  }
  searchResult()
 { 

   this.cookie.set('searchParam',this.search.toLowerCase());
 }
 addToCart(bottle){
    
  alert("Procuct Added To Cart")
  // this.cartService.setCart(mobile);  
   this.cartService.addCart(bottle.productId).subscribe((data)=>{}) 
  
}

}
