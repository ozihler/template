import {Component, Input, OnInit} from '@angular/core';
import {AbstractControl, FormGroup, ValidationErrors} from "@angular/forms";

@Component({
  selector: 'user-identifiers',
  templateUrl: './user-identifiers-field.component.html'
})
export class UserIdentifiersFieldComponent implements OnInit {

  @Input() userIdentifiers: FormGroup;

  constructor() {
  }


  get emailField(): AbstractControl {
    return this.userIdentifiers.get('emailField');
  }

  get emailFieldErrors(): ValidationErrors {
    return this.userIdentifiers.get('emailField')['errors'];
  }

  get hasEmailFieldErrors() {
    return this.userIdentifiers.get('emailField')['errors'];
  }

  ngOnInit() {
  }

}
