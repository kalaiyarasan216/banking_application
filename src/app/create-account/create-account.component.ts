import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl} from '@angular/forms'
import { CustomerService}from '../customer.service';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {
  alert:boolean = false
  addCustomer= new FormGroup({
    name: new FormControl(''),
    email_id: new FormControl(''),
    amount: new FormControl('')
  })
  constructor(private cust:CustomerService) { }

  ngOnInit(): void {
  }
  onSubmit(){
    this.cust.saveCustomer(this.addCustomer.value).subscribe((result)=>{
      // console.warn("result is here",result)
      this.alert = true
      this.addCustomer.reset({})
    })
  }
  closeAlert(){
    this.alert = false
  }
}
