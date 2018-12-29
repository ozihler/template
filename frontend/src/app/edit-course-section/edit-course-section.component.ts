import {Component, OnInit} from '@angular/core';
import {CoursesService} from "../courses/courses.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-edit-course-section',
  templateUrl: './edit-course-section.component.html',
  styleUrls: ['./edit-course-section.component.css']
})
export class EditCourseSectionComponent implements OnInit {


  constructor(private route: ActivatedRoute, private courseService: CoursesService) {
  }

  ngOnInit() {

  }

}
