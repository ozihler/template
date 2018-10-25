import {Component, OnInit} from "@angular/core";
import {QuestionForm} from "./question-form";
import {Question} from "./domain/question";

@Component({
  selector: 'app-question-form',
  templateUrl: './question-form.component.html',
  styleUrls: ['./question-form.component.css']
})
export class QuestionFormComponent implements OnInit {

  questions: Question[] = [];
  questionForm

  constructor() {
    this.questionForm = QuestionForm.createQuestionForm();
  }

  ngOnInit() {
  }

  public submitQuestion() {
    let formData = this.questionForm.value;
    console.log(formData);
    this.questions.push(Question.createFrom(formData));

    this.questionForm.reset();
  }


  get email() {
    return this.questionForm.get("email");
  }
}
