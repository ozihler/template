import {FormGroup} from "@angular/forms";

export class Course {
  id: number;
  title: string;
  description: string;
  thumbnailUrl: string;
  rating: number;

  public setDataFrom(courseForm: FormGroup) {
    let value = courseForm.value;
    this.title = value.title;
    this.description = value.description;
    this.thumbnailUrl = value.thumbnailUrl;
    this.rating = value.rating;
  }
}
