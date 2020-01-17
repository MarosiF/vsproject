import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { HttpClientModule } from '@angular/common/http';
import { ProductService } from './services/product.service';
import { UserListComponent } from './components/user-list/user-list.component';
import { ShoppingcartComponent } from './components/shoppingcart/shoppingcart.component';
import { UserService } from './services/user.service';
import { ShoppingcartService } from './services/shoppingcart.service';

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    UserListComponent,
    ShoppingcartComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
  ],
  providers: [ProductService],
  //providers: [UserService],
  //providers: [ShoppingcartService],
  bootstrap: [AppComponent]
})
export class AppModule { }
