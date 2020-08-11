import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { CartserviceService } from '../cartservice.service';

@Component({
  selector: 'app-protein-products',
  templateUrl: './protein-products.component.html',
  styleUrls: ['./protein-products.component.css']
})
export class ProteinProductsComponent implements OnInit {
  proteins : Product[];
  productPrice:String[]=[];
  constructor(private service : ProductService, private cartService : CartserviceService) { }

  ngOnInit(): void {
    this.service.getProteins().subscribe( (data : Product[])=>{
         
      this.proteins =  data;
      for(let i=0;i<data.length;i++)
      {
       // console.log(data[i].variants[0].price)
        this.productPrice[i]=data[i].variants[0].price;
        console.log(this.productPrice[i])
      }
 
    })
  }
  addToCart(protein){
        
    alert("Procuct Added To Cart")
    // this.cartService.setCart(mobile);  
     this.cartService.addCart(protein.productId).subscribe((data)=>{})  
    
 }
 getPrice(productId,price,j){
  console.log("got price")
  this.productPrice[j]=price.toString();
     this.service.updatePrice(productId,price).subscribe()
  
    }
}
