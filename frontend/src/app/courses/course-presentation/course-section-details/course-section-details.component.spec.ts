import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseSectionDetailsComponent } from './course-section-details.component';

describe('CourseSectionDetailsComponent', () => {
  let component: CourseSectionDetailsComponent;
  let fixture: ComponentFixture<CourseSectionDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CourseSectionDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseSectionDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
