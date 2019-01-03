import {Routes} from "@angular/router";
import {CoursesOverviewComponent} from "./courses/course-presentation/courses-overview/courses-overview.component";
import {CourseDetailsComponent} from "./courses/course-presentation/course-details/course-details.component";
import {AddCourseComponent} from "./courses/course-creation/add-course/add-course.component";
import {EditCourseComponent} from "./courses/course-creation/edit-course/edit-course.component";
import {EditCourseSectionComponent} from "./courses/course-creation/edit-course/edit-course-section/edit-course-section.component";
import {CreatedCoursesOverviewComponent} from "./courses/course-creation/created-courses-overview/created-courses-overview.component";
import {CourseWizardComponent} from "./courses/course-presentation/course-wizard/course-wizard.component";
import {CourseSectionsOverviewComponent} from "./courses/course-presentation/course-sections-overview/course-sections-overview.component";
import {CourseSectionDetailsComponent} from "./courses/course-presentation/course-section-details/course-section-details.component";

export const routes: Routes = [
  {path: 'created-courses-overview', component: CreatedCoursesOverviewComponent},
  {path: 'add-course', component: AddCourseComponent},
  {path: 'courses', component: CoursesOverviewComponent},
  {path: 'course/:id', component: CourseDetailsComponent},
  {path: 'course/:id/sections', component: CourseWizardComponent},
  {path: 'course/:id/overview', component: CourseSectionsOverviewComponent},
  {path: 'section/:id', component: CourseSectionDetailsComponent},
  {path: 'edit-course/:id', component: EditCourseComponent},
  {path: 'edit-course-section/:id', component: EditCourseSectionComponent},
  {path: '', redirectTo: '/courses', pathMatch: 'full'}
];
