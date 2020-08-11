import { Injectable } from '@angular/core';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor() { }
  sharedData : {

     user  : User;
  }

  sharedCounter : {
     count : number;
  }
}
