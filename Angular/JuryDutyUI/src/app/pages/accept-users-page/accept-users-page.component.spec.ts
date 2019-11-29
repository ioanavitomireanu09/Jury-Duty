import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AcceptUsersPageComponent } from './accept-users-page.component';

describe('AcceptUsersPageComponent', () => {
  let component: AcceptUsersPageComponent;
  let fixture: ComponentFixture<AcceptUsersPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AcceptUsersPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AcceptUsersPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
