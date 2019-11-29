import { GradeWeight } from './GradeWeight';

export class ContestToInsert {
	id: number;
	name: string;
	contestTypeId: number;
	state: number;
	currentRound: number;
	roundState: number;
	numOfParticipants: number;
	isPrivate: number;
	tieBreakId: number;
	numOfJurys: number;
	password: string;
	numOfRounds: number;
	orgUsername: string;

	
	gradeWeightList: GradeWeight[];
}