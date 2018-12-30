import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {CourseSection} from "../../../entities/course-section";

@Component({
  selector: 'app-course-section',
  templateUrl: './course-section.component.html',
  styleUrls: ['./course-section.component.css']
})
export class CourseSectionComponent implements OnInit {

  @Input()
  courseSection: CourseSection;
  @Input()
  isAddButton: boolean = true;
  @Output()
  courseSectionEvent: EventEmitter<CourseSection> = new EventEmitter();

  buttonText: string;

  constructor() {
  }

  ngOnInit() {
    if (!this.courseSection) {
      this.courseSection = new CourseSection()
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
