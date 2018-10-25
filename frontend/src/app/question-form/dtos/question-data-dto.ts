export class QuestionDataDto {
  constructor(public topics: string, public title: string, public questionText: string) {

  }


  static create(topicsField: string, titleField: string, questionTextArea: string): QuestionDataDto {
    return new QuestionDataDto(topicsField, titleField, questionTextArea);
  }
}
