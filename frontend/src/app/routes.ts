import {Routes} from "@angular/router";
import {CoursesComponent} from "./courses/courses.component";
import {HomeComponent} from "./home/home.component";
import {CourseDetailsComponent} from "./course-details/course-details.component";
import {AddCourseComponent} from "./add-course/add-course.component";
import {EditCourseComponent} from "./edit-course/edit-course.component";
import {EditCourseSectionComponent} from "./edit-course-section/edit-course-section.component";

export const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'add-course', component: AddCourseComponent},
  {path: 'courses', component: CoursesComponent},
  {path: 'course/:id', component: CourseDetailsComponent},
  {path: 'edit-course/:id', component: EditCourseComponent},
  {path: 'edit-course-section/:id', component: EditCourseSectionComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'}
];
