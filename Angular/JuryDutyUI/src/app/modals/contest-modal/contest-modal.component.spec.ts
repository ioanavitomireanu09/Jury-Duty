import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ContestModalComponent } from './contest-modal.component';

describe('ContestModalComponent', () => {
  let component: ContestModalComponent;
  let fixture: ComponentFixture<ContestModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ContestModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ContestModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
