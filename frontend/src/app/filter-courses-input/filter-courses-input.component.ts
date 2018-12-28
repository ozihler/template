import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl} from "@angular/forms";
import {CoursesService} from "../courses/courses.service";
import {debounceTime, distinctUntilChanged} from "rxjs/operators";

@Component({
  selector: 'app-filter-courses-input',
  templateUrl: './filter-courses-input.component.html',
  styleUrls: ['./filter-courses-input.component.css']
})
export class FilterCoursesInputComponent implements OnInit {
  filterCoursesInput: FormControl;
  @Output() filterCoursesEvent: EventEmitter<Preview[]> = new EventEmitter();
  private FILTER_FORM_CONTROL_DEBOUNCE_TIME_IN_MILLISECS: number = 400;
  private error: string;
  private numberOfMatches: number = -1;

  constructor(private coursesService: CoursesService) {
    this.filterCoursesInput = this.createFilterFormControl();
  }

  public filterCourses(query: string) {
    this.coursesService.getCoursePreviewsStartingWith(query)
      .subscribe(previews => {
        this.numberOfMatches = previews.length;
        this.filterCoursesEvent.emit(previews);
      }, error => {
        this.error = JSON.stringify(error);
      });
  }

  ngOnInit() {
  }

  private createFilterFormControl(): FormControl {
    let formControl = new FormControl('');
    formControl.valueChanges
      .pipe(
        debounceTime(this.FILTER_FORM_CONTROL_DEBOUNCE_TIME_IN_MILLISECS),
        distinctUntilChanged())
      .subscribe(query => this.filterCourses(query));
    return formControl;
  }

}
