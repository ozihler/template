import {Routes} from "@angular/router";
import {QuestionFormComponent} from "./question-form/question-form.component";
import {BlogComponent} from "./blog/blog.component";
import {HomeComponent} from "./home/home.component";

export const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'question-form', component: QuestionFormComponent},
  {path: 'blog', component: BlogComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'}
];
