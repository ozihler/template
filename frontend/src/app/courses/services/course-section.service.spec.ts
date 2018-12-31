import {TestBed} from '@angular/core/testing';

import {CourseSectionService} from './course-section.service';

describe('CourseSectionService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CourseSectionService = TestBed.get(CourseSectionService);
    expect(service).toBeTruthy();
  });
});
