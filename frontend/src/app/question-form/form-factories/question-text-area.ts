import {FormControl} from "@angular/forms";

export class QuestionTextArea extends FormControl {
  public static create():QuestionTextArea{
    return new QuestionTextArea();
  }
}
