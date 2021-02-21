import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../customer.service'
import {FormControl,FormGroup} from '@angular/forms'

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.css']
})
export class TransferComponent implements OnInit {
  alert:boolean = false
  transferAmount = new FormGroup({
    fromAccount: new FormControl(''),
    toAccount: new FormControl(''),
    amount: new FormControl('')
  })
  constructor(private cust : CustomerService) { }
  collection:any

  ngOnInit(): void {
    this.cust.getList().subscribe((result)=>{
      console.warn(result)
      this.collection = result
    })
  }
  onSubmit(){
    this.cust.transferAmount(this.transferAmount.value).subscribe((result)=>{
      // console.warn("result is here",result)
      this.alert = true;
      this.transferAmount.reset({})
    })
   
  }
  closeAlert(){
    this.alert = false
  }
}
