import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JurydashComponent } from './jurydash.component';

describe('JurydashComponent', () => {
  let component: JurydashComponent;
  let fixture: ComponentFixture<JurydashComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JurydashComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JurydashComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
