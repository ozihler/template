import {Routes} from "@angular/router";
import {CoursesOverviewComponent} from "./courses/course-presentation/courses-overview/courses-overview.component";
import {HomeComponent} from "./home/home.component";
import {CourseDetailsComponent} from "./courses/course-presentation/course-details/course-details.component";
import {AddCourseComponent} from "./courses/course-creation/add-course/add-course.component";
import {EditCourseComponent} from "./courses/course-creation/edit-course/edit-course.component";
import {EditCourseSectionComponent} from "./courses/course-creation/edit-course/edit-course-section/edit-course-section.component";

export const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'add-course', component: AddCourseComponent},
  {path: 'courses', component: CoursesOverviewComponent},
  {path: 'course/:id', component: CourseDetailsComponent},
  {path: 'edit-course/:id', component: EditCourseComponent},
  {path: 'edit-course-section/:id', component: EditCourseSectionComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'}
];
