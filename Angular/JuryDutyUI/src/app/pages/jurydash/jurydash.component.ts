import { Component, OnInit } from '@angular/core';
import { ContestService } from 'src/app/core/services/api/contest.service';
import { Contest } from 'src/app/core/entities/Contest';
import { StorageService } from 'src/app/core/services/storage/storage.service';
import { User } from 'src/app/core/entities/User';
import { StorageKey } from 'src/app/core/services/storage/storage.model';
import { TeamService } from 'src/app/core/services/api/team.service';
import { Team } from 'src/app/core/entities/Team';

const { USER_DATA } = StorageKey;

@Component({
  selector: 'app-jurydash',
  templateUrl: './jurydash.component.html',
  styleUrls: ['./jurydash.component.scss']
})
export class JurydashComponent implements OnInit {
  contestList: Contest[];
  selectedContest: Contest;
  selectedTeam: Team;
  userData: User;
  teamList: any;
  memberList: any;
  panelOpenState = false;

  constructor(private contestService: ContestService,
              private teamService: TeamService,
              private storage: StorageService) {
    this.userData = this.storage.read(USER_DATA).userDetails || null;
  }

  ngOnInit() {
    this.contestService.getContests(this.userData.username).then((res: Contest[]) => {
      this.contestList = res;
    });
  }

  onSelectTeam(team: Team): void {
    this.selectedTeam = team;
    this.memberList = this.teamService.getTeamMembers(team.teamId);
  }

  onSelectContest(contest: Contest): void {
    this.selectedContest = contest;
    this.teamList = this.teamService.getTeams(contest.contestId);
  }
}
