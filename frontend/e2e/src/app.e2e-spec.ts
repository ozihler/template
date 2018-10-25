import { QuestionFormPage } from './users/pages/questionform.po';
import {QuestionFormUser} from "./users/QuestionFormUser";



describe('Question page', () => {
   let questionFormUser: QuestionFormUser;

  beforeEach(() => {
    questionFormUser = new QuestionFormUser();
  });

  it('should display a form to enter a question', () => {
    questionFormUser.visitsQuestionFormPage();
    questionFormUser.seesQuestionForm();

  });
});
