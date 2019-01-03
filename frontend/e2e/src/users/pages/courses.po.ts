import {browser, by, element, ElementFinder} from 'protractor';

export class CoursesPage {
  static navigateTo() {
    return browser.get('/courses');
  }

  getSubmitButton(): ElementFinder {
    return CoursesPage.elementById('submit-question-button');
  }

  getTitleField(): ElementFinder {
    return CoursesPage.elementById('question-title')
  }

  getTextField(): ElementFinder {
    return CoursesPage.elementById('question-text');
  }

  private static elementById(submitQuestionButton) {
    return element(by.id(submitQuestionButton));
  }

  static searchForCourse(courseTitle: string) {
      CoursesPage.elementById('filter-courses-input');
  }
}
