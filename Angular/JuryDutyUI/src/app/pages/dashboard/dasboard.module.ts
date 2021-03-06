import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardPageRoutingModule } from './dasboard-routing.module';
import { DashboardComponent } from './dashboard.component';
import { LogoModule } from '../../core/components/logo/logo.module';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { FlexLayoutModule } from '@angular/flex-layout';
import { FormsModule } from '@angular/forms';
import {MatTabsModule} from '@angular/material/tabs';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatButtonToggleModule} from '@angular/material/button-toggle'; 
import {MatIconModule} from '@angular/material/icon';
import {MatToolbarModule} from '@angular/material/toolbar'; 
import {MatDividerModule} from '@angular/material/divider'; 
import {MatListModule} from '@angular/material/list';

@NgModule({
    declarations: [DashboardComponent],
    imports: [
        CommonModule,
        DashboardPageRoutingModule,
        LogoModule,
        MatCardModule,
        MatInputModule,
        MatButtonModule,
        FlexLayoutModule,
        FormsModule,
        MatTabsModule,
        MatExpansionModule,
        MatButtonToggleModule,
        MatIconModule,
        MatToolbarModule,
        MatDividerModule,
        MatListModule
    ],
})
export class DashboardModule {}
