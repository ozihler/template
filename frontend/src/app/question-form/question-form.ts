import {FormControl, FormGroup, Validators} from "@angular/forms";

export class QuestionForm {

  public static createQuestionForm() {
    return new FormGroup({
      username: this.createUsernameField(),
      email: this.createEmailField(),
      topics: this.createTopicsField(),
      title: this.createTitleField(),
      question: this.createQuestionTextArea()
    });
  }

  private static createQuestionTextArea() {
    return new FormControl();
  }

  private static createTitleField() {
    return new FormControl();
  }

  private static createTopicsField() {
    return new FormControl();
  }

  private static createUsernameField() {
    return new FormControl();
  }

  private static createEmailField() {
    return new FormControl("",
      [
        Validators.required,
        Validators.pattern('[a-zA-z0-9_\.]+@[a-zA-Z]+\.[a-zA-Z]+')
      ]
    );
  }
}
