import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {RouterModule, Routes} from '@angular/router';
import {ReactiveFormsModule} from "@angular/forms";
import {QuestionFormComponent} from "./question-form/question-form.component";
import { EmailFieldComponent } from './question-form/email-field/email-field.component';
import { UserIdentifiersFieldComponent } from './question-form/username-field/user-identifiers-field.component';
import { QuestionDataComponent } from './question-form/question-data/question-data.component';

const appRoutes: Routes = [
  {
    path: '',
    redirectTo: '/question-form',
    pathMatch: 'full'
  },
  {
    path: 'question-form',
    component: QuestionFormComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    QuestionFormComponent,
    EmailFieldComponent,
    UserIdentifiersFieldComponent,
    QuestionDataComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
