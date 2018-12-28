import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-star-rating',
  templateUrl: './star-rating.component.html',
  styleUrls: ['./star-rating.component.css']
})
export class StarRatingComponent implements OnInit {

  @Input() maxRating: number[];
  @Input() courseRating: number;

  constructor() {
  }

  ngOnInit() {
  }
}
