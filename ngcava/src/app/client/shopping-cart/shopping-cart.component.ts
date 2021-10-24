import { Component, OnInit } from "@angular/core";
import { AlertService } from "src/app/core/services/alert.service";
import { UserService } from "src/app/core/services/user.service";
import { carroCompraGet } from "../models/carroGet";
import { CartService } from "../service/cart.service";

@Component({
    selector: 'app-cart',
    templateUrl: './shopping-cart.component.html'
})
export class ShoppingCartComponent implements OnInit{
    carroCompra : carroCompraGet = { total : 0, id: 0, productos: [] };
    constructor(
        private _cart : CartService,
        private _user : UserService,
        private _alert : AlertService
    ){}
    ngOnInit(){
        this.getProductsById();
    }

    getProductsById(){
        this._cart.getProductsByIdCarroCompra(this._user.getUser().carro)
            .subscribe((response) => {
                this.carroCompra = response; 
                console.log(response);
            }, badRequest => {
                this._alert.error(badRequest);
            })
    }

    deleteById(id : number){
        this._cart.deleteItem(id, this._user.getUser().carro)
            .subscribe(() => {
                this._alert.success('Se ha eliminado el producto de su carrito');
                this.getProductsById();
            }, badRequest => {
                this._alert.error(badRequest);
            });
    }
}