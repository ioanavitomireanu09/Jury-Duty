export class GradeWeight {
  gradeWeight: number;
  gradeType: string;

  constructor(gradeType?: string, gradeWeight?: number) {
    this.gradeType = gradeType;
    this.gradeWeight = gradeWeight;
  }
}