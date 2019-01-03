import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl} from "@angular/forms";
import {CoursesService} from "../../../services/courses.service";
import {debounceTime, distinctUntilChanged} from "rxjs/operators";
import {Preview} from "../../../entities/preview";

@Component({
  selector: 'app-filter-courses-input',
  templateUrl: './filter-courses-input.component.html',
  styleUrls: ['./filter-courses-input.component.css']
})
export class FilterCoursesInputComponent implements OnInit {
  private static FILTER_FORM_CONTROL_DEBOUNCE_TIME_IN_MILLISECS: number = 400;

  public filterCoursesInput: FormControl;
  @Output()
  public filterCoursesEvent: EventEmitter<Preview[]> = new EventEmitter();
  public error: string;
  public numberOfMatches: number = -1;

  constructor(private coursesService: CoursesService) {
    this.filterCoursesInput = this.createFilterFormControl();
  }

  public filterCourses(query: string) {
    this.coursesService.getCoursePreviewsContaining(query)
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
        debounceTime(FilterCoursesInputComponent.FILTER_FORM_CONTROL_DEBOUNCE_TIME_IN_MILLISECS),
        distinctUntilChanged())
      .subscribe(query => this.filterCourses(query));
    return formControl;
  }

}
