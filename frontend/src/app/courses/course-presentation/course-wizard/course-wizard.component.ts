import {Component, OnInit} from '@angular/core';
import {CourseSection} from "../../entities/course-section";
import {CourseSectionService} from "../../services/course-section.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-start-course',
  templateUrl: './course-wizard.component.html',
  styleUrls: ['./course-wizard.component.css']
})
export class CourseWizardComponent implements OnInit {
  courseSections: CourseSection[];
  currentCourseSection: CourseSection;
  currentPage: number = 0;
  error: string;
  //this is a hack: if undefined, the editor takes the height of its content, which is the desired behaviour
  height: number = undefined;

  constructor(private courseSectionService: CourseSectionService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.params
      .subscribe(params => {
          let courseId = parseInt(params['id']);
          this.courseSectionService.getAllCourseSectionsForCourse(courseId)
            .subscribe(courseSections => {
              this.courseSections = courseSections;
              this.currentCourseSection = this.courseSections[this.currentPage];
            }, error => {
              this.error = JSON.stringify(error)
            });
        }
      );
  }

  nextSection(): void {
    if (this.currentPage < this.courseSections.length - 1) {
      this.currentCourseSection = this.courseSections[++this.currentPage];
    }
  }

  previousSection(): void {
    if (this.currentPage > 0) {
      this.currentCourseSection = this.courseSections[--this.currentPage];
    }
  }
}
