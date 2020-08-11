import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { CartserviceService } from '../cartservice.service';
import { CookieService } from 'ngx-cookie-service';
import { ProductService } from '../product.service';
import { Product } from '../product';

@Component({
  selector: 'app-order-history',
  templateUrl: './order-history.component.html',
  styleUrls: ['./order-history.component.css']
})
export class OrderHistoryComponent implements OnInit {
 listMap:Map<Date,Product[]>=new Map<Date,Product[]>();
 public date =new Date();
userId;
cart;
  constructor(private router:ActivatedRoute,private cartService:CartserviceService,private cookie:CookieService,private productService:ProductService) { }

  ngOnInit(): void {
   this.userId=this.cookie.get('userId');
   this.cartService.showOrder(this.userId).subscribe((data)=>{
     this.cart=data;
     for(let i=0;i<this.cart.length;i++)
    {
      var tempOrder:Product[]=[];
      this.productService.getById(this.cart[i].productId).subscribe((data1:Product[])=>{
       data1[0].quantity=this.cart[i].quantity;
        var temp=data1[0].variants[0].price.split(" ",1);
       data1[0].price=parseInt(temp[0]);
      if(this.listMap.has(this.cart[i].date)==false)
      this.listMap.set(this.cart[i].date,data1);
      else {
        var item:Product[];
        item=this.listMap.get(this.cart[i].date);
        item.push(data1[0])
        this.listMap.set(this.cart[i].date,item)
      }
     })
     
    } 
  })
}}
