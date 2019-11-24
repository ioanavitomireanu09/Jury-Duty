import { Component, OnInit, Inject } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

export class StatsContest {
	teams: any[];
}

export class Contest {
	name: string;
	state: number;
	stats: StatsContest;
}

@Component({
	selector: 'app-contest-console',
	templateUrl: './contest-console.component.html',
	styleUrls: ['./contest-console.component.scss']
})
export class ContestConsoleComponent implements OnInit {
	
	public contest: Contest;
	public breakpoint: number; // Breakpoint observer code

	constructor (
	public dialog: MatDialog,
	private dialogRef: MatDialogRef<ContestConsoleComponent>,
	@Inject(MAT_DIALOG_DATA) contest: Contest ) {

	this.contest = contest;
	}

	ngOnInit() {
	}

	// tslint:disable-next-line:no-any
	public onResize(event: any): void {
		this.breakpoint = event.target.innerWidth <= 600 ? 1 : 2;
	}

	close() {
		this.dialogRef.close();
	}
}
