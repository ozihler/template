import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {RouterModule, Routes} from '@angular/router';
import {ReactiveFormsModule} from "@angular/forms";
import {QuestionFormComponent} from "./question-form/question-form.component";

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
    QuestionFormComponent
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
