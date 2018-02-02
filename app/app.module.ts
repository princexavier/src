import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { routing} from './app.route';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AddbookComponent } from './addbook/addbook.component';
import { RouterModule } from '@angular/router/src/router_module';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AddbookComponent,

  ],
  imports: [
    BrowserModule,routing 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
