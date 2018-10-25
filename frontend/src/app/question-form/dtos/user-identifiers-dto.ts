export class UserIdentifiersDto {
  constructor(public username: string, public email: string) {

  }


  public static create(usernameField: string, emailField: string): UserIdentifiersDto {
    return new UserIdentifiersDto(usernameField, emailField);
  }
}
