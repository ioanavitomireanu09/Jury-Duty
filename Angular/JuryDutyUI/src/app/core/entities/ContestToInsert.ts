import { GradeWeight } from './GradeWeight';

export class ContestToInsert {
    name: string;
    contestTypeId: number;
    isPrivate: number;
    tieBreakId: number;
    numOfJurys: number;
    password: string;
    numOfRounds: number;
    orgUsername: string;
    gradeWeightList: GradeWeight[];
  }