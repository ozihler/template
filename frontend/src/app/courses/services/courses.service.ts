import {Inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../../environments/environment";
import {Course} from "../entities/course";

@Injectable({
  providedIn: 'root'
})
export class CoursesService {

  private baseUrl = `${environment.baseUrl}courses`;

  constructor(@Inject("windowObject") private window: Window, private httpClient: HttpClient) {
  }

  public getCoursePreviews(): Observable<Preview[]> {
    return this.httpClient.get<Preview[]>(`${this.baseUrl}/previews`);
  }

  public getCoursePreviewsContaining(filterText: string): Observable<Preview[]> {
    return this.httpClient.get<Preview[]>(`${this.baseUrl}/previews?q=${filterText}`);
  }

  public getMaxRating(): Observable<MaxRating> {
    return this.httpClient.get<MaxRating>(`${this.baseUrl}/currentMaxRating`);
  }

  public getCourse(id: string): Observable<Course> {
    return this.httpClient.get<Course>(`${this.baseUrl}/${id}`);
  }

  public postCourse(course: Course): Observable<Course> {
    return this.httpClient.post<Course>(`${this.baseUrl}`, course);
  }

  public putCourse(course: Course): Observable<Course> {
    return this.httpClient.put<Course>(`${this.baseUrl}/${course.id}`, course);
  }

  public getAllCourses(): Observable<Course[]> {
    return this.httpClient.get<Course[]>(`${this.baseUrl}`);
  }

  public deleteCourse(id: number): Observable<Course> {
    return this.httpClient.delete<Course>(`${this.baseUrl}/${id}`);
  }

  getCourseAsPdf(id: number): void {
    this.window.open(`${this.baseUrl}/${id}/pdf`);
  }
}
