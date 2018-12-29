export class CourseSection {
  static counter: number = 1;
  id: number;
  sectionTitle: string;
  sectionMarkdown: string;

  constructor(sectionTitle: string, sectionMarkdown: string, id: number = CourseSection.counter++) {
    this.id = id;
    this.sectionTitle = sectionTitle;
    this.sectionMarkdown = sectionMarkdown;
  }
}
