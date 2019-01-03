import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Course} from "../../entities/course";

@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.css']
})
export class CourseFormComponent implements OnInit {

  courseForm: FormGroup;
  @Input()
  course: Course = new Course();
  @Input()
  buttonText: string;
  @Output()
  private submitEvent: EventEmitter<Course> = new EventEmitter();
  public hasImageError: boolean = false;

  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.courseForm = this.createCourseForm();
  }

  public submit(): void {
    if (!this.course) {
      this.course = new Course();
    }

    this.updateDataInCourseFromForm(this.course, this.courseForm);
    this.submitEvent.emit(this.course);
  }

  public updateDataInCourseFromForm(course: Course, courseForm: FormGroup): void {
    let value = courseForm.value;
    this.course.title = value.title;
    this.course.description = value.description;
    this.course.thumbnailUrl = value.thumbnailUrl;
    this.course.rating = value.rating;
  }

  private createCourseForm(): FormGroup {
    let title: string = this.course ? this.course.title : '';
    let description: string = this.course ? this.course.description : '';
    let thumbnailUrl: string = this.course ? this.course.thumbnailUrl : '';


    let formGroup = this.formBuilder.group({
      title: title,
      description: description,
      thumbnailUrl: thumbnailUrl
    });

    return formGroup;
  }

  setError($event): void {
    this.hasImageError = true;
  }
}
