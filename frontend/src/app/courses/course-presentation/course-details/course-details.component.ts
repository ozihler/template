import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {CoursesService} from "../../services/courses.service";
import {Course} from "../../entities/course";


@Component({
  selector: 'app-course-details',
  templateUrl: './course-details.component.html',
  styleUrls: ['./course-details.component.css']
})
export class CourseDetailsComponent implements OnInit {
  course: Course;
  error: any;

  constructor(private route: ActivatedRoute, private courseService: CoursesService) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.courseService.getCourse(params['id'])
        .subscribe(course => {
          this.course = course;
        }, error => {
          this.error = error;
        });
    });
  }

  downloadPdf() {
    this.courseService.getCourseAsPdf(this.course.id);
  }
}
