import {Component, OnInit} from '@angular/core';
import {CoursesService} from "../../services/courses.service";
import {ActivatedRoute} from "@angular/router";
import {Course} from "../../entities/course";
import {CourseSection} from "../../entities/course-section";
import {CourseSectionService} from "../../services/course-section.service";

@Component({
  selector: 'app-add-course-pages',
  templateUrl: './edit-course.component.html',
  styleUrls: ['./edit-course.component.css']
})
export class EditCourseComponent implements OnInit {
  private error: string;
  course: Course;
  shouldShowEditCourseForm: boolean;
  private courseSections: CourseSection[];

  constructor(private route: ActivatedRoute, private courseService: CoursesService, private courseSectionService: CourseSectionService) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.courseService.getCourse(params['id'])
        .subscribe(course => {
          this.course = course;
          this.courseSectionService.getAllCourseSectionsForCourse(course.id)
            .subscribe(courseSections => {
              this.courseSections = courseSections;
            }, error => {
              this.handleError(error);
            });
        }, error => {
          this.handleError(error);
        });
    });
  }

  public addCourseSection(courseSection: CourseSection) {
    this.courseSectionService.createCourseSection(courseSection)
      .subscribe(courseSection => {
        this.courseSections.push(courseSection);
      }, error => {
        this.handleError(error)
      });
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
    this.shouldShowEditCourseForm = !this.shouldShowEditCourseForm;
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
