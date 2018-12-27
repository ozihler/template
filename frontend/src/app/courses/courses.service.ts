import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class CoursesService {

  private baseUrl = environment.baseUrl;

  constructor(private httpClient: HttpClient) {
  }

  public getThumbs(): Observable<Thumb[]> {
    return this.httpClient.get<Thumb[]>(`${this.baseUrl}courses/thumbs`);
  }

  public getMaxRating():Observable<MaxRating> {
    return this.httpClient.get<MaxRating>(`${this.baseUrl}courses/currentMaxRating`);

  }
}
