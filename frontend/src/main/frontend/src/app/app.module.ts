import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {appService} from "./app.service";
import {NumberOnlyDirective} from "./number.directive";

@NgModule({
  declarations: [
    AppComponent,
    NumberOnlyDirective
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    HttpModule
  ],
  providers: [appService],
  bootstrap: [AppComponent]
})
export class AppModule { }
