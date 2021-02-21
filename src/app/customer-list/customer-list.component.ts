import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../customer.service';
import {Observable, observable} from "rxjs";
@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  router: any;

  constructor(private cust : CustomerService) { }
  collection:any;
  ngOnInit(): void {
    this.cust.getList().subscribe((result)=>{
      console.warn(result)
      this.collection=result
    })
  }
}
