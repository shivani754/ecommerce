import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { CartserviceService } from '../cartservice.service';

@Component({
  selector: 'app-pens',
  templateUrl: './pens.component.html',
  styleUrls: ['./pens.component.css']
})
export class PensComponent implements OnInit {
  

  pens : Product[];
  productPrice:String[]=[];
  constructor(private service : ProductService, private cartService : CartserviceService) { }

  ngOnInit(): void {
    this.service.getPens().subscribe( (data : Product[])=>{
         
      this.pens=  data;
      for(let i=0;i<data.length;i++)
      {
       // console.log(data[i].variants[0].price)
        this.productPrice[i]=data[i].variants[0].price;
        console.log(this.productPrice[i])
      }

    })
  }
  addToCart(pen){
        
    alert("Procuct Added To Cart")
    // this.cartService.setCart(mobile);  
     this.cartService.addCart(pen.productId).subscribe((data)=>{})
 }
 getPrice(productId,price,j){
  console.log("got price")
  this.productPrice[j]=price.toString();
     this.service.updatePrice(productId,price).subscribe()
  
    }

}
