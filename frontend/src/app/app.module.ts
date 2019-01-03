import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {RouterModule} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {routes} from "./routes";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {CoursesOverviewComponent} from './courses/course-presentation/courses-overview/courses-overview.component';
import {CourseDetailsComponent} from './courses/course-presentation/course-details/course-details.component';
import {CoursePreviewComponent} from './courses/course-presentation/course-preview/course-preview.component';
import {StarRatingComponent} from './courses/course-presentation/star-rating/star-rating.component';
import {FilterCoursesInputComponent} from './courses/course-presentation/courses-overview/filter-courses-input/filter-courses-input.component';
import {AddCourseComponent} from './courses/course-creation/add-course/add-course.component';
import {LMarkdownEditorModule} from "ngx-markdown-editor";
import {MarkdownModule} from "ngx-markdown";
import {EditCourseSectionComponent} from './courses/course-creation/edit-course/edit-course-section/edit-course-section.component';
import {EditCourseComponent} from "./courses/course-creation/edit-course/edit-course.component";
import {CourseSectionOverviewTableComponent} from './courses/course-creation/edit-course/course-section-overview-table/course-section-overview-table.component';
import {CourseFormComponent} from './courses/course-creation/course-form/course-form.component';
import {CourseSectionComponent} from './courses/course-creation/edit-course/course-section/course-section.component';
import {CreatedCoursesOverviewComponent} from './courses/course-creation/created-courses-overview/created-courses-overview.component';
import {CourseWizardComponent} from './courses/course-presentation/course-wizard/course-wizard.component';
import { CourseSectionsOverviewComponent } from './courses/course-presentation/course-sections-overview/course-sections-overview.component';

@NgModule({
  declarations: [
    AppComponent,
    CoursesOverviewComponent,
    CourseDetailsComponent,
    CoursePreviewComponent,
    StarRatingComponent,
    FilterCoursesInputComponent,
    AddCourseComponent,
    EditCourseComponent,
    EditCourseSectionComponent,
    CourseSectionOverviewTableComponent,
    CourseFormComponent,
    CourseSectionComponent,
    CreatedCoursesOverviewComponent,
    CourseWizardComponent,
    CourseSectionsOverviewComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    LMarkdownEditorModule,
    FormsModule,
    MarkdownModule.forRoot()
  ],
  providers: [HttpClient,
    {provide: "windowObject", useValue: window}],
  bootstrap: [AppComponent]
})
export class AppModule {
}
