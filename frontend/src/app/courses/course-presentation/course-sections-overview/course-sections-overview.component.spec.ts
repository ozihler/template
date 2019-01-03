import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import { CourseSectionsOverviewComponent } from './course-sections-overview.component';

describe('CourseSectionsOverviewComponent', () => {
  let component: CourseSectionsOverviewComponent;
  let fixture: ComponentFixture<CourseSectionsOverviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CourseSectionsOverviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseSectionsOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
