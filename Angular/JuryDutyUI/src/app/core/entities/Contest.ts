export class StatsContest {
	teams: any[];
}

export class Contest {
	contestId: number;
	name: string;
	state: number;
	stats: StatsContest;
}