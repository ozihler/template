import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {RouterModule} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {routes} from "./routes";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {HomeComponent} from './home/home.component';
import {CoursesComponent} from './courses/courses.component';
import {CourseDetailsComponent} from './course-details/course-details.component';
import {CoursePreviewComponent} from './course-preview/course-preview.component';
import {StarRatingComponent} from './star-rating/star-rating.component';
import {FilterCoursesInputComponent} from './filter-courses-input/filter-courses-input.component';
import {AddCourseComponent} from './add-course/add-course.component';
import {LMarkdownEditorModule} from "ngx-markdown-editor";
import {MarkdownModule} from "ngx-markdown";
import {EditCourseSectionComponent} from './edit-course-section/edit-course-section.component';
import {EditCourseComponent} from "./edit-course/edit-course.component";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CoursesComponent,
    CourseDetailsComponent,
    CoursePreviewComponent,
    StarRatingComponent,
    FilterCoursesInputComponent,
    AddCourseComponent,
    EditCourseComponent,
    EditCourseSectionComponent
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
  providers: [HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule {
}
