import { Component, Input } from "@angular/core";
import { ProductoGrid } from "src/app/shared/models/ProductoGrid";
import { Productos } from "src/app/shared/models/Productos";
import { Carro } from "../models/carro";
import { AlertService } from "../../core/services/alert.service";
import { CartService } from "../service/cart.service";
import { UserService } from "../../core/services/user.service";

@Component({
    selector: 'app-grid-product',
    templateUrl: './grid-product.component.html'
})
export class GridProductComponent{
    @Input() productos : ProductoGrid[] = [];
    cart : Carro = { producto: null, carroCompra: '' };
    constructor(
        private _cart : CartService,
        private _user : UserService,
        private _alert: AlertService
    ){}

    addProductToCart(producto : ProductoGrid){
        if(this.isClient()){
            this.cart.carroCompra = { id : this._user.getUser().carroCompra['id'] };
            this._cart.saveItem(this.cart)
                .subscribe(() => {
                    this._alert.success(`Agregaste ${producto.nombre} a tu carrito`);
                }, badRequest => {
                    this._alert.error(badRequest.error);
                })
        }else{
            this._alert.info("Inicia sesión para añadir productos al carrito");
        }
    }

    isClient(){
        if(this._user.getUser()){
            return this._user.getUser().usuario['rol'].toUpperCase() == 'cliente'.toUpperCase();
        }
        return false;
    }
}