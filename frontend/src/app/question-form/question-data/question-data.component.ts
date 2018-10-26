import {Component, Input, OnInit} from '@angular/core';
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'question-data',
  templateUrl: './question-data.component.html'
})
export class QuestionDataComponent implements OnInit {

  @Input() questionData: FormGroup;

  constructor() {
  }


  ngOnInit() {
  }

}
