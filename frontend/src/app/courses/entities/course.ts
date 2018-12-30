import {CourseSection} from "./course-section";

export class Course {
  id: number;
  title: string;
  description: string;
  thumbnailUrl: string;
  rating: number;
  courseSections: CourseSection[] = []
}