import {Component, OnInit} from '@angular/core';
import {Location} from '@angular/common';
import {ActivatedRoute} from "@angular/router";
import {CourseSection} from "../../../entities/course-section";
import {CourseSectionService} from "../../../services/course-section.service";

@Component({
  selector: 'app-edit-course-section',
  templateUrl: './edit-course-section.component.html',
  styleUrls: ['./edit-course-section.component.css']
})
export class EditCourseSectionComponent implements OnInit {
  error: string;
  courseSectionToEdit: CourseSection = new CourseSection();

  constructor(private route: ActivatedRoute, private location: Location, private courseSectionService: CourseSectionService) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      let courseSectionId: number = parseInt(params['id']);
      this.courseSectionService.getCourseSection(courseSectionId)
        .subscribe(courseSection => {
          this.courseSectionToEdit = courseSection;
        }, error => {
          this.handleError(error)
        });
    });
  }

  updateCourseSection(courseSectionToUpdate: CourseSection) {
    this.courseSectionService.updateCourseSection(courseSectionToUpdate)
      .subscribe(courseSection => {
        this.courseSectionToEdit = courseSection;
        this.location.back();
      }, error => {
        this.handleError(error)
      });
  }

  private handleError(error) {
    this.error = JSON.stringify(error);
  }
}
