import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router'; 
import {CustomerListComponent} from './customer-list/customer-list.component';
import {CreateAccountComponent} from './create-account/create-account.component';
import {TransferComponent} from './transfer/transfer.component';
import {HistoryComponent} from './history/history.component';
import {HomeComponent}from './home/home.component';
import { CustomerDetailComponent } from './customer-detail/customer-detail.component';

const routes: Routes = [
  {
    component : CustomerListComponent,
    path:'list'
  },
  {
    component : CreateAccountComponent,
    path:'create'
  },
  {
    component : TransferComponent,
    path:'transfer'
  },
  {
    component : HistoryComponent,
    path:'history'
  },
  {
    component : HomeComponent,
    path:'home'
  },
  {
    path:"customerDetail/:id",component:CustomerDetailComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
