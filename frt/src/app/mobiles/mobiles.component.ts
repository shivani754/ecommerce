import { Component, OnInit } from '@angular/core';
import {ProductService} from '../product.service';
import {Product} from '../product';
import { CartserviceService } from '../cartservice.service';
import { CartComponent } from '../cart/cart.component';

@Component({
  selector: 'app-mobiles',
  templateUrl: './mobiles.component.html',
  styleUrls: ['./mobiles.component.css']
})
export class MobilesComponent implements OnInit {

  constructor(private service : ProductService, private cartService : CartserviceService) { }
    
  mobiles : Product[]; 
productPrice:String[]=[];
  ngOnInit(): void {
      
    this.service.getMobiles().subscribe( (data : Product[])=>{
      this.mobiles=  data;
      for(let i=0;i<data.length;i++)
      {
       // console.log(data[i].variants[0].price)
        this.productPrice[i]=data[i].variants[0].price;
        console.log(this.productPrice[i])
      }
    })

    
  }

  addToCart(mobile){
        
    alert("Procuct Added To Cart")
    // this.cartService.setCart(mobile);  
     this.cartService.addCart(mobile.productId).subscribe((data)=>{})
     
  }
  getPrice(productId,price,j){
console.log("got price")
this.productPrice[j]=price.toString();
   this.service.updatePrice(productId,price).subscribe()

  }

}
