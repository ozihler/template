import {Routes} from "@angular/router";
import {PinupWallComponent} from "./pinup-wall/pinup-wall.component";


export const routes: Routes = [
  {path: 'pinupwall', component: PinupWallComponent},
  {path: '', redirectTo: '/pinupwall', pathMatch: 'full'}
];
