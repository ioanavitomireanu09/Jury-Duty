/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { ContestService } from './contest.service';

describe('Service: Contest', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ContestService]
    });
  });

  it('should ...', inject([ContestService], (service: ContestService) => {
    expect(service).toBeTruthy();
  }));
});
