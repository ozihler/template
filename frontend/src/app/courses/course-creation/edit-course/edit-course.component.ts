import {Component, OnInit} from '@angular/core';
import {CoursesService} from "../../courses.service";
import {ActivatedRoute} from "@angular/router";
import {Course} from "../../entities/course";
import {CourseSection} from "../../entities/course-section";

@Component({
  selector: 'app-add-course-pages',
  templateUrl: './edit-course.component.html',
  styleUrls: ['./edit-course.component.css']
})
export class EditCourseComponent implements OnInit {
  private error: string;
  course: Course;
  shouldShowEditCourseForm: boolean;

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

  addCourseSection(courseSection: CourseSection) {
    this.course.courseSections.push(courseSection);

    this.update(this.course);
  }


  private handleError(error) {
    this.error = JSON.stringify(error);
  }

  update(courseToUpdate: Course) {
    this.courseService.putCourse(courseToUpdate)
      .subscribe(course => {
        this.course = course;
      }, error => {
        this.handleError(error)
      });
  }


  showEditCourseForm(): void {
    this.shouldShowEditCourseForm = true;
  }

  hideEditCourseForm(): void {
    this.shouldShowEditCourseForm = false;
  }
}
