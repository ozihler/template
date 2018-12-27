import {Component, OnInit} from '@angular/core';
import {CoursesService} from "./courses.service";

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {
  public maxRating;
  public courses: Thumb[] = [];
  public error: any;

  constructor(private coursesService: CoursesService) {
    this.maxRating = Array(5).fill(5).map((x, i) => i);
    console.log(this.maxRating)
  }

  ngOnInit() {
    this.coursesService.getMaxRating()
      .subscribe(maxRating => {
        this.maxRating = CoursesComponent.createMaxRatingList(maxRating);
        this.fetchCourseThumbs();
      }, error => {
        this.error = error;
      });
  }

  private fetchCourseThumbs() {
    this.coursesService.getThumbs()
      .subscribe(courses => {
        this.courses = courses;
      }, error => {
        this.error = error;
      })
  }

  private static createMaxRatingList(maxRating) {
    return Array(maxRating.maxRating).fill(maxRating.maxRating).map((x, i) => i);
  }
}
