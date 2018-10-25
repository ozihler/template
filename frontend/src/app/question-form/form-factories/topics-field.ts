import {FormControl} from "@angular/forms";

export class TopicsField extends FormControl {
  public static create() :TopicsField{
    return new TopicsField();
  }
}
