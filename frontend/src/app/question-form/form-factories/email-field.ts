import {FormControl, Validators} from "@angular/forms";

export class EmailField extends FormControl {

  constructor() {
    super("",
      [
        Validators.required,
        Validators.pattern('[a-zA-z0-9_\.]+@[a-zA-Z]+\.[a-zA-Z]+')
      ]);
  }

  public static create() {
    return new EmailField();
  }
}
