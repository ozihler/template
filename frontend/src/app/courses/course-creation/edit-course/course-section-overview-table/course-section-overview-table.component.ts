import {Component, Input, OnInit} from '@angular/core';
import {CourseSection} from "../../../entities/course-section";
import {Course} from "../../../entities/course";
import {CoursesService} from "../../../courses.service";

@Component({
  selector: 'app-course-section-overview-table',
  templateUrl: './course-section-overview-table.component.html',
  styleUrls: ['./course-section-overview-table.component.css']
})
export class CourseSectionOverviewTableComponent implements OnInit {

  @Input() course: Course;

  constructor(private courseService: CoursesService) {
  }

  ngOnInit() {
  }

  deleteCourseSection(courseSection: CourseSection): void {
    this.course.courseSections = this.copyCourseSectionsWithout(courseSection);

    this.update(this.course);
  }

  private copyCourseSectionsWithout(courseSectionToDelete: CourseSection): CourseSection[] {
    let courseSectionsCopy: CourseSection[] = [];
    for (const courseSection of this.course.courseSections) {
      if (courseSection.id !== courseSectionToDelete.id) {
        courseSectionsCopy.push(courseSection);
      }
    }
    return courseSectionsCopy;
  }

  private update(courseToUpdate: Course): void {
    this.courseService.putCourse(courseToUpdate)
      .subscribe(course => {
        this.course = course;
      });
  }

}
