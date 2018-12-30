import {Component, OnInit} from '@angular/core';
import {CoursesService} from "../../courses.service";
import {ActivatedRoute} from "@angular/router";
import {CourseSection} from "../../entities/course-section";
import {Course} from "../../entities/course";

@Component({
  selector: 'app-edit-course-section',
  templateUrl: './edit-course-section.component.html',
  styleUrls: ['./edit-course-section.component.css']
})
export class EditCourseSectionComponent implements OnInit {
  error: string;
  courseSectionToEdit: CourseSection;
  private course: Course;

  constructor(private route: ActivatedRoute, private courseService: CoursesService) {
  }

  private static findCourseSectionToEdit(course: Course, courseSectionId: number): CourseSection {
    for (const courseSection of course.courseSections) {
      if (courseSection.id === courseSectionId) {
        return courseSection;
      }
    }
    return null;
  }

  ngOnInit() {
    this.route.params.subscribe(params => {

      this.courseService.getCourse(params['id'])
        .subscribe(course => {
          this.course = course;

          this.route.queryParams.subscribe(queryParams => {
            let courseSectionId: number = parseInt(queryParams["courseSectionId"]);
            this.courseSectionToEdit = EditCourseSectionComponent.findCourseSectionToEdit(this.course, courseSectionId);
          });
        }, error => {
          this.handleError(error);
        });
    });
  }

  update(courseSectionToUpdate: CourseSection) {
    for (const value  of this.course.courseSections) {
      if (value.id === courseSectionToUpdate.id) {
        value.sectionTitle = courseSectionToUpdate.sectionTitle;
        value.sectionMarkdown = courseSectionToUpdate.sectionMarkdown;
      }
    }

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
