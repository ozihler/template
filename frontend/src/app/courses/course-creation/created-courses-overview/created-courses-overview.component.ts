import {Component, OnInit} from '@angular/core';
import {Course} from "../../entities/course";
import {CoursesService} from "../../services/courses.service";

@Component({
  selector: 'app-created-courses-overview',
  templateUrl: './created-courses-overview.component.html',
  styleUrls: ['./created-courses-overview.component.css']
})
export class CreatedCoursesOverviewComponent implements OnInit {

  private error: string;
  private courses: Course[];

  constructor(private coursesService: CoursesService) {
  }

  ngOnInit() {
    this.coursesService.getAllCourses()
      .subscribe(courses => {
        this.courses = courses;
      }, error => {
        this.error = JSON.stringify(error);
      });
  }

}
