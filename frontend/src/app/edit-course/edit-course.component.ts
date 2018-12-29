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

  addCourseElement() {
    let courseSection = new CourseSection(this.currentCourseSectionTitle, this.currentCourseSectionMarkDown);
    this.course.courseSections.push(courseSection);

    this.courseService.putCourse(this.course)
      .subscribe(course => {
        this.course = course;
      }, error => {
        this.handleError(error)
      });
  }

  private handleError(error) {
    this.error = JSON.stringify(error);
  }
}
