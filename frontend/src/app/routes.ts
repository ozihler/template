import {Routes} from "@angular/router";
import {QuestionFormComponent} from "./question-form/question-form.component";
import {CoursesComponent} from "./courses/courses.component";
import {HomeComponent} from "./home/home.component";
import {CourseDetailsComponent} from "./course-details/course-details.component";

export const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'question-form', component: QuestionFormComponent},
  {path: 'courses', component: CoursesComponent},
  {path: 'course/:id', component: CourseDetailsComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'}
];
