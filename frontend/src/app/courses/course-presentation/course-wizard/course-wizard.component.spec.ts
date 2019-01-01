import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {CourseWizardComponent} from './course-wizard.component';

describe('StartCourseComponent', () => {
  let component: CourseWizardComponent;
  let fixture: ComponentFixture<CourseWizardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [CourseWizardComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseWizardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
