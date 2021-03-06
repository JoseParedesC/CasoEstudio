import { Component, Input } from "@angular/core";
import { ProductoGrid } from "src/app/shared/models/ProductoGrid";
import { Carro } from "../../client/models/carro";
import { AlertService } from "../services/alert.service";
import { CartService } from "../../client/service/cart.service";
import { UserService } from "../services/user.service";

@Component({
    selector: 'app-grid-product',
    templateUrl: './grid-product.component.html'
})
export class GridProductComponent{
    @Input() productos : ProductoGrid[] = [];
    cart : Carro = { producto: null, carroCompra: '', cantidad: 1 };
    constructor(
        private _cart : CartService,
        private _user : UserService,
        private _alert: AlertService
    ){}

    addProductToCart(producto : ProductoGrid){
        if(this.isClient()){
            this.cart.carroCompra = { id : this._user.getUser().carro };
            this.cart.producto = { id: producto.id };
            this._cart.saveItem(this.cart)
                .subscribe(() => {
                    this._alert.success(`Agregaste ${producto.nombre} a tu carrito`);
                }, badRequest => {
                    this._alert.error(badRequest);
                })
        }else{
            this._alert.info("Inicia sesión para añadir productos al carrito");
        }
    }

    isClient(){
        if(this._user.getUser()){
            return this._user.getUser().rol.toUpperCase() == 'cliente'.toUpperCase();
        }
        return false;
    }
}