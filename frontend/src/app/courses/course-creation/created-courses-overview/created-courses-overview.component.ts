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

  deleteCourse(id: number): void {
    this.coursesService.deleteCourse(id)
      .subscribe(course => {
        this.courses = this.copyCoursesWithout(course);
      }, error => {
        this.error = JSON.stringify(error);
      });
  }

  private copyCoursesWithout(course: Course) {
    let copy: Course[] = [];
    for (const c of this.courses) {
      if (c.id !== course.id) {
        copy.push(c);
      }
    }
    return copy;
  }
}
