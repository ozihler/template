import {Component, OnInit} from '@angular/core';
import {CoursesService} from "./courses.service";
import {MaxRatingService} from "../star-rating/max-rating.service";

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {
  maxRating: number[] = [];
  previews: Preview[] = [];
  error: string;

  constructor(private coursesService: CoursesService) {
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

  public displayFilteredCoursePreviews(previews: Preview[]): void {
    this.previews = previews;
  }

  private fetchCoursePreviews(): void {
    this.coursesService.getCoursePreviews()
      .subscribe(previews => {
        this.previews = previews;
      }, error => {
        this.error = JSON.stringify(error);
      });
  }
}
