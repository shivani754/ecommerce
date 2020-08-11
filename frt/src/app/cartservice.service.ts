import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartserviceService {

  order;
  cart  ;
  private apiUrl= 'http://localhost:8081/cart/';
  userheader={'content-type':'application/json','Access-Control-Allow-Origin':'*'}
  constructor(private http:HttpClient,private cookie:CookieService) { }
  // addProductToCart(userId,product_id)
  // {
  //   console.log(userId)
  //   return this.http.post(this.apiUrl+userId,product_id);
  // }
  checkout(userId:string)
  {
     return this.http.get(this.apiUrl+userId,{'headers':this.userheader});
  }
 showOrder(userId)
 {
   var url="http://localhost:8081/order/";
   return this.http.get(url+userId);
 }
  mergeUserNDummy(dummyUserId,userId)
  {
    console.log(dummyUserId+" "+userId)
    return this.http.put(this.apiUrl+"mergecart/"+userId+"/"+dummyUserId,{'headers':this.userheader});
  }
  showCart(userid)
  {
    return this.http.get(this.apiUrl+userid);
  }
  deleteproduct(userId,productId)
  {
    return this.http.delete(this.apiUrl+userId+"/"+productId);
  }
  decreaseProductFromCart(userId,productId)
  {
    return this.http.put(this.apiUrl+userId,productId,{'headers':this.userheader});
  }
  increaseProduct(userId,product_id)
  {
    return this.http.put(this.apiUrl+"/increase/"+userId,product_id);
  }

  sendEmail(order,email)
  {
    console.log(order)
   var url="http://localhost:8081/email/send/"
    return this.http.post(url+email,order);
  }

  delete(userId)
  {
    console.log("delete called")
    return this.http.delete(this.apiUrl+"delete/"+userId);
  }
  addToOrder(userId,productId,quantity)
  {
    var url="http://localhost:8081/order/";
    console.log(productId)
    return this.http.post(url+userId+"/"+productId,quantity);
  }
  addCart(productId)
  {
    console.log("addcart:"+productId)
    var userId;
    if(this.cookie.check('dummyUserId')==false&&this.cookie.get('loginstatus')=="false")
    this.cookie.set('dummyUserId',Math.floor(Math.random()*1000000).toString());
    if(this.cookie.get('loginstatus')=="true")
    {
     // this.loginFlag=true;
      userId=this.cookie.get('userId');
    }
    else userId=this.cookie.get('dummyUserId');
    console.log(userId)
    return this.http.post(this.apiUrl+userId,productId);
  }
 
  orderHistory(userId): Observable<any>
  {
    var url="http://localhost:8081/order/orderhistory/";
    return this.http.get<any>(url+userId);
  }
}
