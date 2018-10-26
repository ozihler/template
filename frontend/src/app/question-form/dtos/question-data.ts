export class QuestionData {
  constructor(public topics: string, public title: string, public questionText: string) {
  }

  static create(topics: string, title: string, questionText: string): QuestionData {
    return new QuestionData(topics, title, questionText);
  }
}
