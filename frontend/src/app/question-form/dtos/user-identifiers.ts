export class UserIdentifiers {
  constructor(public name: string, public emailAddress: string) {

  }


  public static create(name: string, emailAddress: string): UserIdentifiers {
    return new UserIdentifiers(name, emailAddress);
  }
}
