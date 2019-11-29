import { Component, OnInit, Input, Inject } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { DeleteComponent } from '../delete/delete.component';
import { ContestToInsert } from 'src/app/core/entities/ContestToInsert';
import { GradeWeight } from 'src/app/core/entities/GradeWeight';


@Component({
  selector: 'app-contest-modal',
  templateUrl: './contest-modal.component.html',
  styleUrls: ['./contest-modal.component.scss']
})
export class ContestModalComponent implements OnInit {
  public breakpoint: number; // Breakpoint observer code
  public contestForm: FormGroup;
  public contestToInsert: ContestToInsert;
  public wasFormChanged = false;
  public selection: number;
  public gradeType: string;
  public gradeWeight: number;
  public contestTypeList = [
    {
      id: 1,
      value: 'Async'
    },
    {
      id: 1,
      value: 'Sync'
    },
    {
      id: 1,
      value: 'Battle'
    }
  ]
  public tieBreakerList = [
    {
      id: 1,
      value: 'Weight'
    }
  ]
  public gradeTypeList = ['Sound', 'Stile'];


  constructor (
    public dialog: MatDialog,
    private fb: FormBuilder,
    private dialogRef: MatDialogRef<ContestModalComponent>,
    @Inject(MAT_DIALOG_DATA) contestToInsert: ContestToInsert ) {
      
      this.contestToInsert = contestToInsert;
    }

    public ngOnInit(): void {
      if (typeof this.contestToInsert == 'undefined' || this.contestToInsert == null) {
        this.contestToInsert = new ContestToInsert();
      }
      this.contestForm = this.fb.group({
        name: [this.contestToInsert.name == null ? null : this.contestToInsert.name, [Validators.required, Validators.pattern('[a-zA-Z]+([a-zA-Z ]+)*')]],
        contestTypeId: [this.contestToInsert.contestTypeId == null ? null : this.contestToInsert.contestTypeId],
        isPrivate: [this.contestToInsert.isPrivate == null ? null : this.contestToInsert.isPrivate],
        tieBreakId: [this.contestToInsert.tieBreakId == null ? null : this.contestToInsert.tieBreakId],
        numOfJurys: [this.contestToInsert.numOfJurys == null ? null : this.contestToInsert.numOfJurys],
        password: [this.contestToInsert.password == null ? null : this.contestToInsert.password],
        numOfRounds: [this.contestToInsert.numOfJurys == null ? null : this.contestToInsert.numOfJurys],
        gradeWeightList: [this.contestToInsert.gradeWeightList == null ? [] : this.contestToInsert.gradeWeightList]
      });
      this.breakpoint = window.innerWidth <= 600 ? 1 : 2; // Breakpoint observer code
    }

    public onAddCus(): void {
      this.markAsDirty(this.contestForm);
    }

    openDialog(): void {
      console.log(this.wasFormChanged);
      if(this.contestForm.dirty) {
        const dialogRef = this.dialog.open(DeleteComponent, {
          width: '340px',
        });
      } else {
        this.dialog.closeAll();
      }
    }

    // tslint:disable-next-line:no-any
    public onResize(event: any): void {
      this.breakpoint = event.target.innerWidth <= 600 ? 1 : 2;
    }

    private markAsDirty(group: FormGroup): void {
      group.markAsDirty();
      // tslint:disable-next-line:forin
      for (const i in group.controls) {
        group.controls[i].markAsDirty();
      }
    }
    onIsPrivate(value) {
      console.log(this.contestForm);
      this.contestForm.value.isPrivate = value;
    }
    formChanged() {
      this.wasFormChanged = true;
    }

    addCategory() { 
      if (this.gradeType != null && this.gradeWeight != null) {
        this.contestForm.value.gradeWeightList.push(new GradeWeight(this.gradeType, this.gradeWeight)); 
        this.gradeType = null
        this.gradeWeight = null
      }
    }
    removeCategory(index : number){
      this.contestForm.value.gradeWeightList.splice(index,1);
    }
    save() {
      this.dialogRef.close(this.contestForm.value);
    }

    close() {
        this.dialogRef.close();
    }

}