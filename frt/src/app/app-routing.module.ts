import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CartComponent } from './cart/cart.component';
import { HomeComponent } from './home/home.component';
import { OrderHistoryComponent } from './order-history/order-history.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './auth.guard';
import { RegistrationComponent } from './registration/registration.component';
import { MobilesComponent } from './mobiles/mobiles.component';
import {SearchComponent} from './search/search.component';
import { BottlesComponent } from './bottles/bottles.component';
import { PensComponent } from './pens/pens.component';
import { WatchesComponent } from './watches/watches.component';
import { ProfileComponent } from './profile/profile.component';
import { ProteinProductsComponent } from './protein-products/protein-products.component';
const routes: Routes = [
{path:"",component:HomeComponent},
{path:"cart",component:CartComponent},
{path:"orderhistory",component:OrderHistoryComponent},
{path : 'login',component: LoginComponent},
{path :'userregistration',component : RegistrationComponent},
{path : 'Mobiles',component : MobilesComponent},
// {path : 'searchresult' , component : SearchComponent},
{path: 'WaterBottles',component : BottlesComponent},
{path : 'Pens',component : PensComponent},
{path : 'Watches',component :WatchesComponent},
{path: 'searchresults',component : SearchComponent},
{path : 'MyProfile', component :  ProfileComponent},
{path :"Proteins",component : ProteinProductsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
