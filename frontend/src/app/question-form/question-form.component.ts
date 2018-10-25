import {Component, OnInit} from "@angular/core";
import {QuestionForm} from "./form-factories/question-form";
import {QuestionsDto} from "./dtos/questions-dto";

@Component({
  selector: 'question-form',
  templateUrl: './question-form.component.html',
  styleUrls: ['./question-form.component.css']
})
export class QuestionFormComponent implements OnInit {

  questions: QuestionsDto[] = [];
  questionForm

  constructor() {
    this.questionForm = QuestionForm.create();
  }

  ngOnInit() {
  }

  public submitQuestion() {
    let formData = this.questionForm.value;
    console.log(formData);
    this.questions.push(QuestionsDto.createFrom(formData));

    this.questionForm.reset();
  }


  get email() {
    return this.questionForm.get("email");
  }
}
