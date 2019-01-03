import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {CourseSectionService} from "../../services/course-section.service";
import {CoursesService} from "../../services/courses.service";
import {Course} from "../../entities/course";
import {CourseSection} from "../../entities/course-section";

@Component({
  selector: 'app-course-sections-overview',
  templateUrl: './course-sections-overview.component.html',
  styleUrls: ['./course-sections-overview.component.css']
})
export class CourseSectionsOverviewComponent implements OnInit {
  private course: Course;
  private courseSections: CourseSection[];
  private error: string;

  constructor(private route: ActivatedRoute,
              private coursesService: CoursesService,
              private courseSectionService: CourseSectionService) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.coursesService.getCourse(parseInt(params['id']))
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
    })
  }

  private handleError(error) {
    this.error = JSON.stringify(error);
  }
}
