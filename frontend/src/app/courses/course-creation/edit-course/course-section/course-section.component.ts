import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {CourseSection} from "../../../entities/course-section";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-course-section',
  templateUrl: './course-section.component.html',
  styleUrls: ['./course-section.component.css']
})
export class CourseSectionComponent implements OnInit {

  @Input()
  courseId: number;
  @Input()
  courseSection: CourseSection;
  @Input()
  isAddButton: boolean = true;
  @Output()
  courseSectionEvent: EventEmitter<CourseSection> = new EventEmitter();

  buttonText: string;

  constructor(private route: ActivatedRoute) {
  }

  ngOnInit() {
    if (!this.courseSection) {
      this.courseSection = new CourseSection();
      this.route.params.subscribe(params => {
        this.courseSection.courseId = parseInt(params['id']);
      })
    }

    this.buttonText = 'Kurselement';
    if (this.isAddButton) {
      this.buttonText = `${this.buttonText} hinzufügen`;
    } else {
      this.buttonText = `${this.buttonText} speichern`;
    }
  }

  public addCourseSection(): void {
    this.courseSectionEvent.emit(this.courseSection);
  }

}
