import {Component, OnInit} from "@angular/core";
import {Question} from "./dtos/question";
import {FormGroupFactory} from "./form-factories/form-group-factory";
import {FormGroup} from "@angular/forms";
import {QuestionService} from "./question.service";

@Component({
  selector: 'question-form',
  templateUrl: './question-form.component.html'
})
export class QuestionFormComponent implements OnInit {

  questions: Question[] = [];
  questionForm: FormGroup;

  constructor(private questionFormService: QuestionService) {
    this.questionForm = FormGroupFactory.createQuestionForm();
  }

  ngOnInit() {
    this.questionFormService.getAll()
      .subscribe(halResponse => {
        this.questions = QuestionService.questionResourcesFrom(halResponse);
      });
  }


  public submitQuestion() {
    let questionsDto = this.questionFormService.post(this.questionFormData())
      .subscribe(question => {
        this.questions.push(question);
      });

    this.questionForm.reset();
  }


  private questionFormData() {
    return this.questionForm.value;
  }

  get email() {
    return this.questionForm.get("email");
  }

  get userIdentifiers() {
    return this.questionForm.get('userIdentifiers');
  }

  get questionData() {
    return this.questionForm.get('questionData');
  }
}
