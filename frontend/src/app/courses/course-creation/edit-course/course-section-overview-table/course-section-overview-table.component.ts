import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {CourseSection} from "../../../entities/course-section";

@Component({
  selector: 'app-course-section-overview-table',
  templateUrl: './course-section-overview-table.component.html',
  styleUrls: ['./course-section-overview-table.component.css']
})
export class CourseSectionOverviewTableComponent implements OnInit {

  @Output() deleteCourseSectionEvent: EventEmitter<CourseSection> = new EventEmitter();
  @Input() courseSections: CourseSection[];

  constructor() {
  }

  ngOnInit() {

  }

  public deleteCourseSection(courseSection: CourseSection): void {
    this.deleteCourseSectionEvent.emit(courseSection);
  }

}
