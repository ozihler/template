import {Component, OnInit} from '@angular/core';
import {CoursesService} from "./courses.service";

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
        this.maxRating = CoursesComponent.createMaxRatingList(maxRating);
        this.fetchCoursePreviews();
      }, error => {
        this.error = error;
      });
  }

  private fetchCoursePreviews() {
    this.coursesService.getPreviews()
      .subscribe(previews => {
        this.previews = previews;
      }, error => {
        this.error = error;
      })
  }

  private static createMaxRatingList(maxRating) {
    return Array(maxRating.maxRating).fill(maxRating.maxRating).map((x, i) => i);
  }
}
