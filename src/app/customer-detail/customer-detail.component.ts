import { Component, OnInit } from '@angular/core';
import { CustomerService} from '../customer.service'
import { ActivatedRoute} from '@angular/router'

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.css']
})
export class CustomerDetailComponent implements OnInit {
  collection:any;
  constructor(private router:ActivatedRoute ,private cust:CustomerService) { }

  ngOnInit(): void {
    console.warn(this.router.snapshot.params.id)
    this.cust.getCustomerDetail(this.router.snapshot.params.id).subscribe((result)=>{
    console.warn(result)
    this.collection = result
    })

  }

}
