import {Component, Input, OnInit} from '@angular/core';
import {Preview} from "../../entities/preview";

@Component({
  selector: 'app-course-preview',
  templateUrl: './course-preview.component.html',
  styleUrls: ['./course-preview.component.css']
})
export class CoursePreviewComponent implements OnInit {
  @Input() preview: Preview;
  @Input() maxRating: number[];

  constructor() {
  }

  ngOnInit() {
  }

}
