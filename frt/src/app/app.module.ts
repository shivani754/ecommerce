import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CartComponent } from './cart/cart.component';
import {FormsModule} from '@angular/forms'
import { HttpClientModule } from '@angular/common/http';
import { OrderHistoryComponent } from './order-history/order-history.component';
import { HomeComponent } from './home/home.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import {CookieService} from 'ngx-cookie-service';
import {AuthGuard} from './auth.guard';
import { MobilesComponent } from './mobiles/mobiles.component';
import { SearchComponent } from './search/search.component';
import { BottlesComponent } from './bottles/bottles.component';
import { PensComponent } from './pens/pens.component';
import { WatchesComponent } from './watches/watches.component';
import { ProfileComponent } from './profile/profile.component';
import { User } from './user';
import { ProteinProductsComponent } from './protein-products/protein-products.component';

@NgModule({
  declarations: [
    AppComponent,
    CartComponent,
    OrderHistoryComponent,
    HomeComponent,
    NavBarComponent,
    LoginComponent,
    RegistrationComponent,
    MobilesComponent,
    SearchComponent,
    BottlesComponent,
    PensComponent,
    WatchesComponent,
    ProfileComponent,
    ProteinProductsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [CookieService,AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
