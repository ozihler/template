import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseSectionDetailsViewComponent } from './course-section-details-view.component';

describe('CourseSectionDetailsViewComponent', () => {
  let component: CourseSectionDetailsViewComponent;
  let fixture: ComponentFixture<CourseSectionDetailsViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CourseSectionDetailsViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseSectionDetailsViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
