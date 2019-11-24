import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GeneraldashComponent } from './generaldash.component';

describe('GeneraldashComponent', () => {
  let component: GeneraldashComponent;
  let fixture: ComponentFixture<GeneraldashComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GeneraldashComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GeneraldashComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
