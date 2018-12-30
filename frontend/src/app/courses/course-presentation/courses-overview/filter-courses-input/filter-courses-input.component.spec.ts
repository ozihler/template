import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {FilterCoursesInputComponent} from './filter-courses-input.component';

describe('FilterCoursesInputComponent', () => {
  let component: FilterCoursesInputComponent;
  let fixture: ComponentFixture<FilterCoursesInputComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [FilterCoursesInputComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FilterCoursesInputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
