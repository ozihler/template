import {Component, OnInit} from '@angular/core';
import {CoursesService} from "./courses.service";
import {MaxRatingService} from "../star-rating/max-rating.service";
import {FormControl} from "@angular/forms";
import {debounceTime, distinctUntilChanged} from "rxjs/operators";

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {
  maxRating: number[] = [];
  previews: Preview[] = [];
  error: string;
  filterCoursesInput: FormControl;

  constructor(private coursesService: CoursesService) {
    this.filterCoursesInput = this.createFilterFormControl();
  }

  private createFilterFormControl(): FormControl {
    let formControl = new FormControl('');
    formControl.valueChanges
      .pipe(
        debounceTime(400),
        distinctUntilChanged())
      .subscribe(query => this.filterCourses(query));
    return formControl;
  }

  ngOnInit() {
    this.coursesService.getMaxRating()
      .subscribe(maxRating => {
        this.maxRating = MaxRatingService.createMaxRatingList(maxRating.maxRating);
        this.fetchCoursePreviews();
      }, error => {
        this.error = JSON.stringify(error);
      });
  }

  private fetchCoursePreviews() {
    this.coursesService.getPreviews()
      .subscribe(previews => {
        this.previews = previews;
      }, error => {
        this.error = JSON.stringify(error);
      });
  }

  public filterCourses(query: string) {
    this.coursesService.getCoursePreviewsStartingWith(query)
      .subscribe(previews => {
        this.previews = previews;
      }, error => {
        this.error = JSON.stringify(error);
      });
  }
}
