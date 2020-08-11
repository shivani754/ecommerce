import { Variants } from './variants';
import { Merchants } from './merchants';


export class Product {

    productId : string;
    productName : string;
    productCategory:string;
    pageNumber:string;
    variants : Variants;
    merchants :Merchants;
    quantity:number;
    productDescription : string;
    imageURLs:string;
    price : number;

}
