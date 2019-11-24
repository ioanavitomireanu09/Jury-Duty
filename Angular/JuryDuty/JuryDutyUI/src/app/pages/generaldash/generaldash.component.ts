import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-generaldash',
  templateUrl: './generaldash.component.html',
  styleUrls: ['./generaldash.component.scss']
})

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
  selector: 'app-generaldash',
  templateUrl: './generaldash.component.html',
  styleUrls: ['./generaldash.component.scss']
})
export class GeneraldashComponent implements OnInit {
    contestList = [];
    selectedTeam: Team;
    public contestToInsert = null;
    
    constructor() { }
    
    ngOnInit() {
      var stats = new StatsContest();
      stats.teams = [{id:1, name:"Team1", members: ["Member 1", "Member 2", "Member 3"]}, 
                    {id:5, name:"Team2", members: ["Member 1", "Member 2", "Member 3"]},
                    {id:3, name:"Team3", members: ["Member 1", "Member 2", "Member 3"]}, 
                    {id:9, name:"Team4", members: ["Member 1", "Member 2", "Member 3"]},
                    {id:1, name:"Team1", members: ["Member 1", "Member 2", "Member 3"]}, 
                    {id:5, name:"Team2", members: ["Member 1", "Member 2", "Member 3"]},
                    {id:3, name:"Team3", members: ["Member 1", "Member 2", "Member 3"]}, 
                    {id:9, name:"Team4", members: ["Member 1", "Member 2", "Member 3"]}
                    ]
      for(let i = 0; i < 10; i++) {
        let contest = new Contest();
        contest.name = "Contest " + i;
        contest.state = i % 2;
        contest.stats = stats;
        this.contestList.push(contest);
      }
      console.log(this.contestList);
    }

    onSelect(team: Team): void {
      this.selectedTeam = team;
    }

    sort(value: any[], criteria: SortCriteria): any[] {
      if (!value || !criteria)
        return value;

      let p: string = criteria.property;

      let sortFn:(a: any, b: any) => any = (a, b) => {
        let value: number = 0;
        if (a[p] === undefined) value = -1;
        else if (b[p] === undefined) value = 1;
        else value = a[p] > b[p] ? 1 : (b[p] > a[p] ? -1 : 0);
        return criteria.descending ? (value * -1) : value;
      };

      value.sort(sortFn);
      return value;
    }
}
