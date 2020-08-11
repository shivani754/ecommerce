import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { CartserviceService } from '../cartservice.service';
import { Product } from '../product';

@Component({
  selector: 'app-watches',
  templateUrl: './watches.component.html',
  styleUrls: ['./watches.component.css']
})
export class WatchesComponent implements OnInit {

  watches : Product[];
  productPrice:String[]=[];
  constructor(private service : ProductService, private cartService : CartserviceService) { }

  ngOnInit(): void {
    this.service.getWatches().subscribe( (data : Product[])=>{
         
      this.watches=  data;
      for(let i=0;i<data.length;i++)
      {
       // console.log(data[i].variants[0].price)
        this.productPrice[i]=data[i].variants[0].price;
        console.log(this.productPrice[i])
      }

    })
  }
  addToCart(watch){
    alert("Procuct Added To Cart")
    // this.cartService.setCart(mobile);  
     this.cartService.addCart(watch.productId).subscribe((data)=>{})
    
 }
 getPrice(productId,price,j){
  console.log("got price")
  this.productPrice[j]=price.toString();
     this.service.updatePrice(productId,price).subscribe()
  
    }

}
