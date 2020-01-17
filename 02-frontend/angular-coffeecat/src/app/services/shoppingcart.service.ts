import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators'
import { Shoppingcart } from '../common/shoppingcart';

@Injectable({
  providedIn: 'root'
})
export class ShoppingcartService {

  private baseUrl = 'http://localhost:8082/shoppingCarts';

  constructor(private httpClient: HttpClient) { }

  getCartList(): Observable<Shoppingcart[]> {
    return this.httpClient.get<GetResponse>(this.baseUrl).pipe(
      map(response => response._embedded.shoppingCarts)
    );
  }

  createShoppingcart(id, user_id, productId, amount){
    return this.httpClient.post('/users/shoppincart/',{
      id, user_id, productId, amount
    })
  }
}


interface GetResponse {
  _embedded: {
    shoppingCarts: Shoppingcart[];
  }
}
