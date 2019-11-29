import { AcceptUsersPageComponent } from './accept-users-page.component';

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [ {path:'',component:AcceptUsersPageComponent,data:{shouldReuse:true,key:'accept-users'}},  ];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AcceptUsersPageRoutingModule { }
