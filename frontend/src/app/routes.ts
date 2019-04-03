import {Routes} from "@angular/router";
import {InitiativesOverviewComponent} from "./initiatives-overview/initiatives-overview.component";


export const routes: Routes = [
  {path: 'initiatives', component: InitiativesOverviewComponent},
  {path: '', redirectTo: '/initiatives', pathMatch: 'full'}
];
