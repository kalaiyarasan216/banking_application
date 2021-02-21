import { Component, OnInit } from '@angular/core';
import { CustomerService} from '../customer.service'

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {


  constructor(private his : CustomerService) { }
  collection:any;
  ngOnInit(): void {
    this.his.getHistoryList().subscribe((result)=>{
      console.warn(result)
      this.collection=result
    })
  }

}
