import {QuestionFormPage} from "./pages/questionform.po";

export class QuestionFormUser {
  private questionFormPage: QuestionFormPage;

  constructor() {
    this.questionFormPage = new QuestionFormPage();
  }

  public visitsQuestionFormPage(): void {
    this.questionFormPage.navigateTo();
  }

  public seesQuestionForm(): void {
    expect(this.questionFormPage.getTitleField().isDisplayed()).toBe(true);
    expect(this.questionFormPage.getTextField().isDisplayed()).toBe(true);
    expect(this.questionFormPage.getSubmitButton().isDisplayed()).toBe(true);
  }
}
