import { QuestionFormPage } from './users/pages/questionform.po';
import {QuestionFormUser} from "./users/QuestionFormUser";
import {CourseUser} from "./users/course-user";



describe('Course user', () => {
   let courseUser: CourseUser;

  beforeEach(() => {
    courseUser = new CourseUser();
  });

  it('should be able to see a course preview and download the course as pdf', () => {
    courseUser.searchesForCourse('Clean Code');

  });
});
