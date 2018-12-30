import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {CoursesService} from "../../courses.service";
import {Course} from "../../entities/course";

@Component({
  selector: 'app-add-course',
  templateUrl: './add-course.component.html',
  styleUrls: ['./add-course.component.css']
})
export class AddCourseComponent implements OnInit {
  error: any;

  constructor(private router: Router, private courseService: CoursesService) {
  }


  ngOnInit() {
  }

  public submitCourse(course: Course): void {
    this.courseService.postCourse(course)
      .subscribe(course => {
        this.router.navigate(['/edit-course', course.id]);
      }, error => {
        this.handleError(error);
      })
  }

  private handleError(error) {
    this.error = JSON.stringify(error);
  }
}
