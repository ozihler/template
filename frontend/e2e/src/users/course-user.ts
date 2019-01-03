import {CoursesPage} from "./pages/courses.po";

export class CourseUser {
  private coursesPage: CoursesPage = new CoursesPage();

  navigatesToCourses(): void {
    CoursesPage.navigateTo();
  }

  searchesForCourse(courseTitle: string) {
    CoursesPage.searchForCourse(courseTitle);
  }
}
