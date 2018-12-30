import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {CourseSectionOverviewTableComponent} from './course-section-overview-table.component';

describe('CourseSectionOverviewTableComponent', () => {
  let component: CourseSectionOverviewTableComponent;
  let fixture: ComponentFixture<CourseSectionOverviewTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [CourseSectionOverviewTableComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseSectionOverviewTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
