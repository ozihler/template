import {Component, Input, OnInit} from '@angular/core';
import {CourseSection} from "../../../entities/course-section";
import {CourseSectionService} from "../../../services/course-section.service";

@Component({
  selector: 'app-course-section-overview-table',
  templateUrl: './course-section-overview-table.component.html',
  styleUrls: ['./course-section-overview-table.component.css']
})
export class CourseSectionOverviewTableComponent implements OnInit {

  @Input() courseSections: CourseSection[];

  constructor(private courseSectionService: CourseSectionService) {
  }

  ngOnInit() {

  }

  deleteCourseSection(courseSection: CourseSection): void {
    this.courseSectionService.delete(courseSection)
      .subscribe((courseSection) => {
        this.courseSections = this.copyCourseSectionsWithout(courseSection);
      });
  }

  private copyCourseSectionsWithout(courseSectionToDelete: CourseSection): CourseSection[] {
    let courseSectionsCopy: CourseSection[] = [];
    for (const courseSection of this.courseSections) {
      if (courseSection.id !== courseSectionToDelete.id) {
        courseSectionsCopy.push(courseSection);
      }
    }
    return courseSectionsCopy;
  }
}
