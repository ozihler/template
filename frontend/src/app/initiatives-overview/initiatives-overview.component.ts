import {Component, OnInit} from '@angular/core';
import {Initiative} from "./initiative";


@Component({
  selector: 'app-initiatives-overview',
  templateUrl: './initiatives-overview.component.html',
  styleUrls: ['./initiatives-overview.component.css']
})
export class InitiativesOverviewComponent implements OnInit {

  initiatives: Initiative[];
  cols: any[];

  constructor() {
  }

  ngOnInit() {
    this.cols = [
      {field: 'title', header: 'Initiativetitel'},
      {field: 'submitDate', header: 'Erstelldatum'},
      {field: 'deadline', header: 'Ablaufdatum'},
      {field: 'username', header: 'Nutzer'},
      {field: 'numberOfVotes', header: 'Anzahl Votes'},
    ];

    this.initiatives = [
      new Initiative("Abschaffung der Drogenverbote", new Date(Date.now()), new Date(Date.now() + 1000 * 60 * 60 * 24 * 100), "ozihler", 123),
      new Initiative("Atombomben für die Schweiz", new Date(Date.now()), new Date(Date.now() + 1000 * 60 * 60 * 24 * 50), "ozihler", 1100),
      new Initiative("Alternativbundesrat", new Date(Date.now()), new Date(Date.now() + 1000 * 60 * 60 * 24 * 14), "hmueller", 5),
      new Initiative("Privatpolizei für alle", new Date(Date.now()), new Date(Date.now() + 1000 * 60 * 60 * 24 * 26), "hmueller", 100),
      new Initiative("Militär abschaffen", new Date(Date.now()), new Date(Date.now() + 1000 * 60 * 60 * 24 * 26), "ozihler", 10000),
    ];
  }

}
