import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {CreatedCoursesOverviewComponent} from './created-courses-overview.component';

describe('CreatedCoursesOverviewComponent', () => {
  let component: CreatedCoursesOverviewComponent;
  let fixture: ComponentFixture<CreatedCoursesOverviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [CreatedCoursesOverviewComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreatedCoursesOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
