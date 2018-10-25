import {FormGroup} from "@angular/forms";
import {UserIdentifiers} from "./user-identifiers";
import {QuestionData} from "./question-data";

export class QuestionForm {

  public static create() {
    return new FormGroup({
      userIdentifiers: UserIdentifiers.create(),
      questionData: QuestionData.create()
    });
  }
}
