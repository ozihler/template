import {UserIdentifiersDto} from "./user-identifiers-dto";
import {QuestionDataDto} from "./question-data-dto";

export class QuestionsDto {
  constructor(public userIdentifiers: UserIdentifiersDto, public questionData: QuestionDataDto) {

  }


  public static createFrom(formData): QuestionsDto {
    return new QuestionsDto(
      UserIdentifiersDto.create(formData.userIdentifiers.usernameField, formData.userIdentifiers.emailField),
      QuestionDataDto.create(formData.questionData.topicsField, formData.questionData.titleField, formData.questionData.questionTextArea)
    );
  }


}
