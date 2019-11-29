import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA, MatDialogConfig } from '@angular/material';
import { ContestModalComponent } from 'src/app/modals/contest-modal/contest-modal.component';
import { ContestConsoleComponent } from 'src/app/modals/contest-console/contest-console.component'
import { ContestToInsert } from 'src/app/core/entities/ContestToInsert';
import { ContestService } from 'src/app/core/services/api/contest.service';
import { StorageKey } from 'src/app/core/services/storage/storage.model';
import { StorageService } from 'src/app/core/services/storage/storage.service';
import { UserService } from 'src/app/core/services/api/user.service';
const { USER_DATA } = StorageKey;

export class Team {
	id: number;
	name: string;
	members: string[];
}
export class StatsContest {
	teams: any[];
}

export class Contest {
	name: string;
	state: number;
	stats: StatsContest;
}

export class ExpansionOverviewExample {
	panelOpenState = false;
}


interface SortCriteria {
	property: string;
	descending?: boolean;
}



@Component({
	selector: 'app-dashboard',
	templateUrl: './dashboard.component.html',
	styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

	contestList = [];
	selectedTeam: Team;
	public contestToInsert = null;

	constructor(public dialog: MatDialog, private contestService: ContestService, private storage: StorageService, private userService: UserService) { }

	ngOnInit() {
		const stats = new StatsContest();
		stats.teams = [{id:1, name:'Team1', members: ['Member 1', 'Member 2', 'Member 3']}, 
						{id:5, name:'Team2', members: ['Member 1', 'Member 2', 'Member 3']},
						{id:3, name:'Team3', members: ['Member 1', 'Member 2', 'Member 3']}, 
						{id:9, name:'Team4', members: ['Member 1', 'Member 2', 'Member 3']},
						{id:1, name:'Team1', members: ['Member 1', 'Member 2', 'Member 3']}, 
						{id:5, name:'Team2', members: ['Member 1', 'Member 2', 'Member 3']},
						{id:3, name:'Team3', members: ['Member 1', 'Member 2', 'Member 3']}, 
						{id:9, name:'Team4', members: ['Member 1', 'Member 2', 'Member 3']}
						]
		for(let i = 0; i < 10; i++) {
			const contest = new Contest();
			contest.name = 'Contest ' + i;
			contest.state = i % 2;
			contest.stats = stats;
			this.contestList.push(contest);
		}
	}

	getGroups(): void {
		this.userService.getUserGroups();
	}

	onSelect(team: Team): void {
		this.selectedTeam = team;
	}

	sort(value: any[], criteria: SortCriteria): any[] {
		if (!value || !criteria) {
			return value;
		}

		const p: string = criteria.property;

		const sortFn:(a: any, b: any) => any = (a, b) => {
			let value = 0;
			if (a[p] === undefined) { value = -1; }
			else if (b[p] === undefined) { value = 1; }
			else { value = a[p] > b[p] ? 1 : (b[p] > a[p] ? -1 : 0); }
			return criteria.descending ? (value * -1) : value;
		};

		value.sort(sortFn);
		return value;
	}

	saveEditContest(contestToInsert?:ContestToInsert) {

		const dialogConfig = new MatDialogConfig();

		dialogConfig.disableClose = true;
		dialogConfig.autoFocus = true;

		dialogConfig.data = contestToInsert;
		dialogConfig.width = '600px';

		const dialogRef = this.dialog.open(ContestModalComponent,
			dialogConfig);


		dialogRef.afterClosed()
			.subscribe(
				(contest: ContestToInsert) => {
					contest.orgUsername = this.storage.read(USER_DATA).userDetails.username;
					let response = this.contestService.saveEditContest(contest)
					console.log('Dialog output:', contest)
					console.log(response);
				}
			);
	}

	onContestConsole() {

		const dialogConfig = new MatDialogConfig();

		dialogConfig.disableClose = true;
		dialogConfig.autoFocus = true;

		dialogConfig.data = new Contest();
		dialogConfig.width = '600px';

		const dialogRef = this.dialog.open(ContestConsoleComponent,
			dialogConfig);


		dialogRef.afterClosed().subscribe(
			val => console.log('Dialog output:', val)
		);
	}
}
