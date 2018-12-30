import {Component, OnInit} from '@angular/core';
import {CoursesService} from "../courses/courses.service";
import {ActivatedRoute} from "@angular/router";
import {Course} from "../input/course";
import {CourseSection} from "../input/course-section";

@Component({
  selector: 'app-add-course-pages',
  templateUrl: './edit-course.component.html',
  styleUrls: ['./edit-course.component.css']
})
export class EditCourseComponent implements OnInit {
  currentCourseSectionTitle: string;
  currentCourseSectionMarkDown: string;
  private error: string;
  private course: Course;

  constructor(private route: ActivatedRoute, private courseService: CoursesService) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.courseService.getCourse(params['id'])
        .subscribe(course => {
          this.course = course;
        }, error => {
          this.handleError(error);
        });
    });
  }

  addCourseSection() {
    let courseSection = new CourseSection(this.currentCourseSectionTitle, this.currentCourseSectionMarkDown);
    this.course.courseSections.push(courseSection);

    this.update(this.course);
  }

  deleteCourseSection(courseSection: CourseSection): void {
    this.course.courseSections = this.copyCourseSectionsWithout(courseSection);

    this.update(this.course);
  }

  private handleError(error) {
    this.error = JSON.stringify(error);
  }

  private update(courseToUpdate: Course) {
    this.courseService.putCourse(courseToUpdate)
      .subscribe(course => {
        this.course = course;
      }, error => {
        this.handleError(error)
      });
  }

  private copyCourseSectionsWithout(courseSectionToDelete: CourseSection) {
    let courseSectionsCopy: CourseSection[] = [];
    for (const courseSection of this.course.courseSections) {
      if (courseSection.id !== courseSectionToDelete.id) {
        courseSectionsCopy.push(courseSection);
      }
    }
    return courseSectionsCopy;
  }
}
