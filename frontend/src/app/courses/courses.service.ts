import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class CoursesService {

  private baseUrl = `${environment.baseUrl}courses`;

  constructor(private httpClient: HttpClient) {
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
}
