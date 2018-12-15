import {FormControl, Validators} from "@angular/forms";

export class FormControlFactory {

  public static createEmailField(): FormControl {
    let emailField = new FormControl();
    emailField.setValidators([
      Validators.required,
      Validators.pattern('[a-zA-z0-9_\.]+@[a-zA-Z]+\.[a-zA-Z]+')
    ]);

    return emailField;
  }

  public static createNameField(): FormControl {
    return new FormControl();
  }

  public static createTopicsField(): FormControl {
    return new FormControl();
  }

  public static createTitleField(): FormControl {
    return new FormControl();
  }

  static createQuestionTextArea(): FormControl {
    return new FormControl();
  }

}
