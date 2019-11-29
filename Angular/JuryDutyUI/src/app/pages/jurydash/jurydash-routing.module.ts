import { NgModule } from '@angular/core';
import { JurydashComponent } from './jurydash.component';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [{ path: '', component: JurydashComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  declarations: []
})
export class JurydashRoutingModule { }
