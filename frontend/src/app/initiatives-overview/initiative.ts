export class Initiative {
  constructor(public title: string,
              public submitDate: Date,
              public deadline: Date,
              public username: string,
              public numberOfVotes: number) {

  }
}
