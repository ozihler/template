import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {Course} from "../../entities/course";

@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.css']
})
export class CourseFormComponent implements OnInit {

  courseForm: FormGroup;
  @Input()
  course: Course;
  @Input() buttonText: string;
  @Output()
  private submitEvent: EventEmitter<Course> = new EventEmitter();

  constructor() {
  }

  ngOnInit() {
    this.courseForm = this.createCourseForm();
  }

  public submit(): void {
    if (!this.course) {
      this.course = new Course();
    }
    let value = this.courseForm.value;
    this.course.title = value.title;
    this.course.description = value.description;
    this.submitEvent.emit(this.course);
  }

  private createCourseForm(): FormGroup {
    let title = this.course ? this.course.title : '';
    let description = this.course ? this.course.description : '';

    return new FormGroup({
      title: new FormControl(title),
      description: new FormControl(description)
    });
  }
}
