import { Component, OnInit, Inject, ViewChild } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { CountdownComponent } from 'ngx-countdown';

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
	@ViewChild('cd1', { static: false }) private countdown: CountdownComponent; 
	public contest: Contest;
	public breakpoint: number;
	public numRounds: number;
	public currentRound: number;
	public currentTeam: number;
	public isContestStart: boolean;
	public isContestDone: boolean;
	public isRoundStart: boolean;
	public isRoundEnd: boolean;
	public teams = []

	constructor (
	public dialog: MatDialog,
	private dialogRef: MatDialogRef<ContestConsoleComponent>,
	@Inject(MAT_DIALOG_DATA) contest: Contest ) {

	this.contest = contest;
	}

	ngOnInit() {
		this.numRounds = 3;
		this.currentRound = 1;
		this.currentTeam = 0;
		this.isContestStart = false;
		this.isContestDone = false;
		this.isRoundStart  = false;
		this.isRoundEnd = false;
		this.teams = [{id:1, name:"Team1", members: ["Member 1", "Member 2", "Member 3"]}, 
						{id:5, name:"Team2", members: ["Member 1", "Member 2", "Member 3"]},
						{id:3, name:"Team3", members: ["Member 1", "Member 2", "Member 3"]}, 
						{id:9, name:"Team4", members: ["Member 1", "Member 2", "Member 3"]}
					]
		}

	// tslint:disable-next-line:no-any
	public onResize(event: any): void {
		this.breakpoint = event.target.innerWidth <= 600 ? 1 : 2;
	}

	close() {
		this.dialogRef.close();
	}

	onStartContest() {
		this.isContestStart = true;
	}

	onEndContest() {
		this.dialogRef.close();
	}

	onStartRound() {
		this.countdown.restart();
		this.countdown.begin();
		this.isRoundStart = true;
	}

	onEndRound() {
		this.currentRound++;
		this.isRoundEnd = false;
	}

	onHandleEvent(event) {
		if(event.action === 'done') {
			if(this.currentTeam == this.teams.length -1) {
				if(this.currentRound == this.numRounds) {
					this.isContestDone = true;
				} else {
					this.isRoundEnd = true;
					this.currentTeam = 0;
					this.isRoundStart = false;
				}
			} else {
				this.currentTeam++;
				this.isRoundStart = false;
			}
		}
	}

	onExit() {
		this.dialogRef.close();
	}
}
