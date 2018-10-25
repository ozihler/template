import {FormGroup} from "@angular/forms";
import {TitleField} from "./title-field";
import {TopicsField} from "./topics-field";
import {QuestionTextArea} from "./question-text-area";

export class QuestionData extends FormGroup {
  constructor() {
    super({
      topicsField: TopicsField.create(),
      titleField: TitleField.create(),
      questionTextArea: QuestionTextArea.create()
    });
  }


  public static create(): QuestionData {
    return new QuestionData();
  }
}
