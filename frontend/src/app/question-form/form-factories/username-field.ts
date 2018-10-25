import {FormControl} from "@angular/forms";

export class UsernameField extends FormControl {

  public static create() {
    return new UsernameField()
  }
}
