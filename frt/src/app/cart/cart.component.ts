import { Component, OnInit } from '@angular/core';
import {CartserviceService} from '../cartservice.service';
import { Router, ActivatedRoute } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import {ProductService} from '../product.service';
import { Product } from '../product';
import { DataService } from '../data.service';
@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cart: any;
  finalCart:Product[] = [] ;
  count=0;
  //dummyFlag=false;
  loginFlag=false;
  total=0
  public userId;
  
  constructor(private route:Router,private cartService:CartserviceService,private cookie :CookieService,private productService:ProductService,
       private dataService : DataService) { }

  ngOnInit(): void {
    
    if(this.cookie.check('dummyUserId')==false)
      this.cookie.set('dummyUserId',Math.floor(Math.random()*1000000).toString());
    if(this.cookie.get('loginstatus')=="true")
    {
      this.loginFlag=true;
      this.userId=this.cookie.get('userId');
    }
    else this.userId=this.cookie.get('dummyUserId');
      this.cartService.showCart(this.userId).subscribe(
      data=>{
        this.cart=data;
        console.log(this.cart);
        this.fetchData();
      }
    )
   
   

  }

deleteproduct(id)
{
      this.cartService.deleteproduct(this.userId,id).subscribe((data)=>{
      this.cart=data;
      this.finalCart.splice(0,this.finalCart.length);
      this.fetchData();
      });
}
decreaseproduct(id)
{

  this.cartService.decreaseProductFromCart(this.userId,id).subscribe((data)=>{
    this.cart=data;
    this.finalCart.splice(0,this.finalCart.length)
    this.fetchData();
 })
}
increaseproduct(id)
{
   this.cartService.increaseProduct(this.userId,id).subscribe((data)=>{
     this.cart=data;
     console.log(this.cart)//is correct
     this.finalCart.splice(0,this.finalCart.length)
     this.fetchData();
   })
}
findtotal()
{ 
  this.total = 0;
  for(let i=0;i<this.finalCart.length;i++)
     this.total+=this.finalCart[i].price * this.finalCart[i].quantity;
  this.count=this.finalCart.length;
}
  checkOut()
  {
      if(this.cookie.get('loginstatus')=="true")
      this.cartService.checkout(this.cookie.get('userId')).subscribe((data) =>
        {
          this.cart=data;
          this.finalCart.splice(0,this.finalCart.length);
          this.fetchData();
          this.setOrderAndMail();
         })
      else
      {
        console.log("came here")
        localStorage.setItem('preCart',JSON.stringify(this.cart));
        this.route.navigate(['/login'])
            this.finalCart.splice(0,this.finalCart.length);
            this.fetchData();
           this.setOrderAndMail();
      }
  }
 fetchData()
 {
   for(let i=0;i<this.cart.length;i++)
     {
        this.productService.getById(this.cart[i].productId).subscribe((data1:Product[])=>{
        data1[0].quantity=this.cart[i].quantity;
        var temp=data1[0].variants[0].price.split(" ",1);
        console.log(temp);
        data1[0].price=parseInt(temp[0]);
        this.finalCart.push(data1[0]);
        this.findtotal();
        })
    }
  
  }
  setOrderAndMail()
  {
   
    var mailCart=[]
    this.cartService.delete(this.cookie.get('userId')).subscribe((data)=>{
      for(let i=0;i<this.finalCart.length;i++)
        {
          var mailCartObj={
            "productName":"",
            "quantity":0,
            "price":0
           }
            mailCartObj.productName=this.finalCart[i].productName;
            mailCartObj.quantity=this.finalCart[i].quantity;
            mailCartObj.price=this.finalCart[i].variants[0].price;
            mailCart.push(mailCartObj);
            this.cartService.addToOrder(this.userId,this.finalCart[i].productId,this.finalCart[i].quantity).subscribe();
        }
     this.cartService.sendEmail(mailCart,this.cookie.get('email')).subscribe();
      this.finalCart.splice(0,this.finalCart.length);
      alert("To check order.Go to my orders")
      this.route.navigate(['/orderhistory']);
      });
  }
}

