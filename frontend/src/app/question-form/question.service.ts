import {Injectable} from '@angular/core';
import {Question} from "./dtos/question";
import {Observable} from "rxjs";
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {
  private questionUrl: string = "http://localhost:8080/questions";

  constructor(private http: HttpClient) {

  }

  public getAll(): Observable<any> {
    return this.http.get(this.questionUrl);
  }

  public post(questionData: FormData): Observable<Question> {
    let question = Question.createFrom(questionData);

    return this.http.post<Question>(this.questionUrl, question);
  }

  public static questionResourcesFrom(halResponse): Question[] {
    if (!halResponse || !halResponse._embedded ) {
      return [];
    }
    return halResponse._embedded.questionOutputResources as Question[];
  }
}
