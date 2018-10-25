import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {FormsModule} from "@angular/forms";
import {RouterModule, Routes} from '@angular/router';
import { QuestionFormComponent } from './question-form/question-form.component';

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
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
