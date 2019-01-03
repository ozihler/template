import {Component, Input, OnInit} from '@angular/core';
import {CourseSection} from "../entities/course-section";

@Component({
  selector: 'app-course-section-details-view',
  templateUrl: './course-section-details-view.component.html',
  styleUrls: ['./course-section-details-view.component.css']
})
export class CourseSectionDetailsViewComponent implements OnInit {

  @Input() courseSection: CourseSection;

  constructor() { }

  ngOnInit() {
  }

}
