import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CourseSection} from "../entities/course-section";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class CourseSectionService {
  private resourcesUrl: string = `${environment.baseUrl}courseSections`;

  constructor(private httpClient: HttpClient) {
  }

  public createCourseSection(courseSection: CourseSection): Observable<CourseSection> {
    return this.httpClient.post<CourseSection>(`${this.resourcesUrl}/`, courseSection);
  }

  public delete(courseSection: CourseSection): Observable<CourseSection> {
    return this.httpClient.delete<CourseSection>(`${this.resourcesUrl}/${courseSection.id}`);
  }

  public getAllCourseSectionsForCourse(courseId: number): Observable<CourseSection[]> {
    return this.httpClient.get<CourseSection[]>(`${this.resourcesUrl}/course/${courseId}`);
  }

  public getCourseSection(id: number): Observable<CourseSection> {
    return this.httpClient.get<CourseSection>(`${this.resourcesUrl}/${id}`);
  }

  public updateCourseSection(courseSection: CourseSection): Observable<CourseSection> {
    return this.httpClient.put<CourseSection>(`${this.resourcesUrl}/${courseSection.id}`, courseSection);
  }
}
