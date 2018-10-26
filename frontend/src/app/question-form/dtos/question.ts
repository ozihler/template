import {UserIdentifiers} from "./user-identifiers";
import {QuestionData} from "./question-data";

export class Question {
  constructor(public userIdentifiers: UserIdentifiers, public questionData: QuestionData) {

  }

  public static createFrom(questionData): Question {
    return new Question(
      UserIdentifiers.create(questionData.userIdentifiers.nameField, questionData.userIdentifiers.emailField),
      QuestionData.create(questionData.questionData.topicsField, questionData.questionData.titleField, questionData.questionData.questionTextArea)
    );
  }
}
