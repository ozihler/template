import {TestBed} from '@angular/core/testing';

import {MaxRatingService} from './max-rating.service';

describe('MaxRatingService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MaxRatingService = TestBed.get(MaxRatingService);
    expect(service).toBeTruthy();
  });
});
