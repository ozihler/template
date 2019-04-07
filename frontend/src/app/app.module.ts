import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {RouterModule} from '@angular/router';
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {routes} from "./routes";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {TableModule} from "primeng/table";
import {PinupWallComponent} from './pinup-wall/pinup-wall.component';

@NgModule({
  declarations: [
    AppComponent,
    PinupWallComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    TableModule,
  ],
  providers: [HttpClient,
    {provide: "windowObject", useValue: window}],
  bootstrap: [AppComponent]
})
export class AppModule { //
}
