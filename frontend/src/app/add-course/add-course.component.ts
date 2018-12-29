import {Component, OnInit} from '@angular/core';
import {CoursesService} from "../courses/courses.service";
import {FormControl, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-course',
  templateUrl: './add-course.component.html',
  styleUrls: ['./add-course.component.css']
})
export class AddCourseComponent implements OnInit {
  error: any;

  courseForm: FormGroup = AddCourseComponent.createCourseForm();

  constructor(private router: Router, private courseService: CoursesService) {
  }

  static createCourseForm() {
    return new FormGroup({
      title: new FormControl(''),
      description: new FormControl('')
    });
  }

  ngOnInit() {
  }

  submitCourse() {
    console.log(this.courseForm.value);
    this.courseService.postCourse(this.courseForm.value)
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
