import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ContestConsoleComponent } from './contest-console.component';

describe('ContestConsoleComponent', () => {
  let component: ContestConsoleComponent;
  let fixture: ComponentFixture<ContestConsoleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ContestConsoleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ContestConsoleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
