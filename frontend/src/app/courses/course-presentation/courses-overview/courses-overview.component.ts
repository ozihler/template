import {Component, OnInit} from '@angular/core';
import {CoursesService} from "../../services/courses.service";
import {MaxRatingService} from "../star-rating/max-rating.service";

@Component({
  selector: 'app-courses',
  templateUrl: './courses-overview.component.html',
  styleUrls: ['./courses-overview.component.css']
})
export class CoursesOverviewComponent implements OnInit {
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
