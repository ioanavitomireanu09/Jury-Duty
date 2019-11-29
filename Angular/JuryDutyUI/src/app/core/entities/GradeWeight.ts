export class GradeWeight {
  gradeType: string;
  gradeWeight: number;

  constructor(gradeType?: string, gradeWeight?: number) {
    this.gradeType = gradeType;
    this.gradeWeight = gradeWeight;
  }
}