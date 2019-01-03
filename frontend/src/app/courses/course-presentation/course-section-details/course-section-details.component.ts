import {Component, OnInit} from '@angular/core';
import {CourseSection} from "../../entities/course-section";
import {ActivatedRoute} from "@angular/router";
import {CourseSectionService} from "../../services/course-section.service";

@Component({
  selector: 'app-course-section-details',
  templateUrl: './course-section-details.component.html',
  styleUrls: ['./course-section-details.component.css']
})
export class CourseSectionDetailsComponent implements OnInit {

  courseSection: CourseSection;

  constructor(private route: ActivatedRoute,
              private courseSectionService: CourseSectionService) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.courseSectionService.getCourseSection(parseInt(params['id']))
        .subscribe(courseSection =>
          this.courseSection = courseSection
        );
    });
  }

}
