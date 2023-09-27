import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PaymentserviceService {

  constructor(private http:HttpClient ) {}
  createTransaction(amount:number){
    return this.http.get(`http://localhost:8080/createTransaction/${amount}`);
  }
}
