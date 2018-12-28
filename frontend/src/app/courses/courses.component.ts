import {Component, OnInit} from '@angular/core';
import {CoursesService} from "./courses.service";
import {MaxRatingService} from "../star-rating/max-rating.service";

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {
  public maxRating: number[] = [];
  public previews: Preview[] = [];
  public error: any;

  constructor(private coursesService: CoursesService) {
  }

  ngOnInit() {
    this.coursesService.getMaxRating()
      .subscribe(maxRating => {
        this.maxRating = MaxRatingService.createMaxRatingList(maxRating.maxRating);
        this.fetchCoursePreviews();
      }, error => {
        this.error = error;
      });
  }

  private fetchCoursePreviews() {
    this.coursesService.getPreviews()
      .subscribe(courses => {
        this.previews = courses;
      }, error => {
        this.error = error;
      })
  }

}
