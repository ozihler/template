import {FormGroup} from "@angular/forms";
import {EmailField} from "./email-field";
import {UsernameField} from "./username-field";

export class UserIdentifiers extends FormGroup {
  constructor() {
    super({
      usernameField: UsernameField.create(),
      emailField: EmailField.create()
    });
  }

  public static create(): UserIdentifiers {
    return new UserIdentifiers();
  }
}
