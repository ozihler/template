export class Question {

  public static createFrom(formData):Question {
    return new Question(
      formData.username,
      formData.email,
      formData.topics,
      formData.title,
      formData.text
    );
  }

  constructor(public username: string,
              public email: string,
              public topics: string[],
              public title: string,
              public text: string
  ) {


  }
}
