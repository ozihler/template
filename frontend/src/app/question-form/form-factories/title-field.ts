import {FormControl} from "@angular/forms";

export class TitleField extends FormControl{
  public static create():TitleField {
    return new TitleField();
  }
}
