import {browser, by, element, ElementFinder} from 'protractor';

export class QuestionFormPage {
  navigateTo() {
    return browser.get('/question-form');
  }

  getSubmitButton(): ElementFinder {
    return this.elementById('submit-question-button');
  }

  getTitleField(): ElementFinder {
    return this.elementById('question-title')
  }

  getTextField(): ElementFinder {
    return this.elementById('question-text');
  }

  private elementById(submitQuestionButton) {
    return element(by.id(submitQuestionButton));
  }
}
