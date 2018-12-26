import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {RouterModule} from '@angular/router';
import {ReactiveFormsModule} from "@angular/forms";
import {QuestionFormComponent} from "./question-form/question-form.component";
import {UserIdentifiersFieldComponent} from './question-form/username-field/user-identifiers-field.component';
import {QuestionDataComponent} from './question-form/question-data/question-data.component';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {BlogComponent} from "./blog/blog.component";
import {routes} from "./routes";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

@NgModule({
  declarations: [
    AppComponent,
    QuestionFormComponent,
    UserIdentifiersFieldComponent,
    QuestionDataComponent,
    BlogComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    BrowserAnimationsModule,
  ],
  providers: [HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule {
}
