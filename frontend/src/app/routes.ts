import {Routes} from "@angular/router";
import {QuestionFormComponent} from "./question-form/question-form.component";
import {BlogComponent} from "./blog/blog.component";

export const routes: Routes = [
  {path: 'blog', component: BlogComponent},
  {path: 'question-form', component: QuestionFormComponent},
  {path: '', redirectTo: '/blog', pathMatch: 'full'}
];
