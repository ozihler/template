import {FormGroup} from "@angular/forms";
import {FormControlFactory} from "./form-control-factory";

export class FormGroupFactory {

  public static createQuestionForm(): FormGroup {
    return new FormGroup({
      userIdentifiers: this.createUserIdentifiersForm(),
      questionData: this.createQuestionDataForm()
    });
  }

  public static createUserIdentifiersForm(): FormGroup {
    return new FormGroup({
      nameField: FormControlFactory.createNameField(),
      emailField: FormControlFactory.createEmailField()
    });
  }

  public static createQuestionDataForm(): FormGroup {
    return new FormGroup({
      topicsField: FormControlFactory.createTopicsField(),
      titleField: FormControlFactory.createTitleField(),
      questionTextArea: FormControlFactory.createQuestionTextArea()
    });
  }
}
