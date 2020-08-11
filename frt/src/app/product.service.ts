import { Injectable } from '@angular/core';
import {HttpClient } from '@angular/common/http' 
import { Product } from './product';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ProductService {

   
  _url = "http://localhost:8082/";

  constructor(private _http  :  HttpClient) { }
  
  

   public getMobiles() :  Observable<Product[]> {

       return this._http.get<Product[]>(this._url + "onlycategory/"+ "mobiles");

   }
   public getBottles() :  Observable<Product[]> {

    return this._http.get<Product[]>(this._url + "onlycategory/"+ "WaterBottle");

   }
   public getPens() :  Observable<Product[]> {

    return this._http.get<Product[]>(this._url + "onlycategory/"+ "Pens");

   }
   public getWatches() :  Observable<Product[]> {

    return this._http.get<Product[]>(this._url + "onlycategory/"+ "Watches");

   }
   public getProteins() :  Observable<Product[]> {

    return this._http.get<Product[]>(this._url + "onlycategory/"+ "Proteins");

   }
   public getById(productId):Observable<Product[]>{
    // console.log(productId);
      return this._http.get<Product[]>(this._url+"onlyid/" + productId);
   } 
  public getProductsBySearch(searchParam):Observable<Product[]>{
    
    return this._http.get<Product[]>(this._url+"search/"+searchParam)
  }


  public mobileProducts() : Observable<Product[]>{
   return this._http.get<Product[]>(this._url + "page/mobiles/1");
  }
  public pensProducts() : Observable<Product[]>{
    return this._http.get<Product[]>(this._url + "page/Pens/1");
  }
  public watchProducts() : Observable<Product[]>{
    return this._http.get<Product[]>(this._url + "page/Watches/1");
  }
  public proteinProducts() : Observable<Product[]> {
    return this._http.get<Product[]>(this._url + "page/Proteins/1");
  }
  public bottleProducts() : Observable<Product[]>{
    return this._http.get<Product[]>(this._url + "page/WaterBottle/1");
  }

 public updatePrice(productId,price ){
     
  return this._http.put(this._url + "update/" + productId +"/"+ price,"");
   
 }




}
