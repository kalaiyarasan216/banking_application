import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
customerurl = "http://localhost:8080/api/customer"
historyurl = "http://localhost:8080/api/history"
transferurl = "http://localhost:8080/api/transferMoney"
detailurl="http://localhost:8080/api/customer/{id}"
  constructor(private http : HttpClient) { }
  getList(){
   return this.http.get(this.customerurl);
  }
  saveCustomer(data: any){
    return this.http.post(this.customerurl,data)
  }
  getHistoryList(){
    return this.http.get(this.historyurl);
  }
  transferAmount(data:any){
    return this.http.post(this.transferurl,data)
  }
  getCustomerDetail(id:any){
    return this.http.get(`${this.customerurl}/${id}`)
  }
}
