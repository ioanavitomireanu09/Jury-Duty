import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { JurydashComponent } from './jurydash.component';
import { JurydashRoutingModule } from './jurydash-routing.module';
import { LogoModule } from 'src/app/core/components/logo/logo.module';
import { MatCardModule, MatInputModule, MatButtonModule, MatTabsModule, MatExpansionModule, MatButtonToggleModule, MatIconModule, MatToolbarModule, MatDividerModule, MatListModule } from '@angular/material';
import { FlexLayoutModule } from '@angular/flex-layout';
import { FormsModule } from '@angular/forms';

@NgModule({
	imports: [
		CommonModule,
		JurydashRoutingModule,
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
	declarations: [JurydashComponent]
})
export class JurydashModule { }
