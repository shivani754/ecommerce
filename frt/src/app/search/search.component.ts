import { Component, OnInit, Input, Output } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { CookieService } from 'ngx-cookie-service';
import { CartserviceService } from '../cartservice.service';


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  
  productresult  :  Product[];
  search : string;
   searchproduct : string ;
   productPrice:String[]=[];
  constructor(private service : ProductService,private cookie:CookieService,private cartService:CartserviceService) { 

     
  }

  ngOnInit(): void {
    this.service.getProductsBySearch(this.cookie.get('searchParam')).subscribe((data:Product[])=>{
      this.productresult=data;
      for(let i=0;i<data.length;i++)
  {
   // console.log(data[i].variants[0].price)
    this.productPrice[i]=data[i].variants[0].price;
    console.log(this.productPrice[i])
  }
      this.searchproduct=this.cookie.get('searchParam');
      console.log(this.productresult);
    
  }) 
  
  }
  
  addToCart(product){
        
    alert("Procuct Added To Cart")
    // this.cartService.setCart(mobile);  
     this.cartService.addCart(product.productId).subscribe((data)=>{})  
    
 }
 getPrice(productId,price,j){
  console.log("got price")
  this.productPrice[j]=price.toString();
     this.service.updatePrice(productId,price).subscribe()
  
    }
  
}
