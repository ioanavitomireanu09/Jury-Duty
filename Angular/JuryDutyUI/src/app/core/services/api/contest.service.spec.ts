<<<<<<< HEAD
import { TestBed } from '@angular/core/testing';

import { ContestService } from './contest.service';

describe('ContestService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ContestService = TestBed.get(ContestService);
    expect(service).toBeTruthy();
  });
=======
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
>>>>>>> 515c56011d9472f1d813810f6d95f37cba0f13ae
});
