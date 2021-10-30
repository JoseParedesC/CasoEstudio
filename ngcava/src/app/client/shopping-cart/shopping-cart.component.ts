import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { AlertService } from "src/app/core/services/alert.service";
import { UserService } from "src/app/core/services/user.service";
import { VentaService } from "src/app/core/services/venta.service";
import { Carro } from "../models/carro";
import { carroCompraGet } from "../models/carroGet";
import { Compra } from "../models/compra";
import { CartService } from "../service/cart.service";

@Component({
    selector: 'app-cart',
    templateUrl: './shopping-cart.component.html'
})
export class ShoppingCartComponent implements OnInit {
    carroCompra: carroCompraGet = { total: 0, id: 0, productos: [] };
    carro: Carro = { carroCompra: null, producto: null, cantidad: 0 };
    //Form
    carroForm : FormGroup;
    constructor(
        private _cart: CartService,
        private _user: UserService,
        private _alert: AlertService,
        private formBuilder: FormBuilder,
        private _venta : VentaService
    ) { 
        this.carroForm = this.formBuilder.group({
            metodoPago: ['', Validators.required],
            nombrePropietario: ['', Validators.required],
            numeroTarjeta: ['', Validators.required],
            fechaExpiracion: ['', Validators.required],
            cvv: ['', Validators.required],
            telefonoContacto: ['', Validators.required],
            direccion: ['', Validators.required]
        });
    }
    ngOnInit() {
        this.setIdcarroCompra();
    }

    saveShop(){
        let compra : Compra = { idCarroCompra: this._user.getUser().carro, ...this.carroForm.value };        
        this._venta.saveCompra(compra)
            .subscribe(() => {
                this._alert.success('Su compra ha sido realizada');
                this.getProductsById();
            }, badRequest => {
                this._alert.error(badRequest);
            })
    }

    getProductsById() {
        this._cart.getProductsByIdCarroCompra(this._user.getUser().carro)
            .subscribe((response) => {
                this.carroCompra = response;
            }, badRequest => {
                this._alert.error(badRequest);
            })
    }

    setIdcarroCompra(){
        if(this._user.getUser()){
            this.getProductsById();
            this.carro.carroCompra = { id: this._user.getUser().carro };
        }
    }

    deleteById(id: number) {
        this._cart.deleteItem(id, this._user.getUser().carro)
            .subscribe(() => {
                this._alert.success('Se ha eliminado el producto de su carrito');
                this.getProductsById();
            }, badRequest => {
                this._alert.error(badRequest);
            });
    }

    selectMethodPay(method : string){
        this.carroForm.get('metodoPago').setValue(method);
    }

    isSelect(method : string){
        return this.carroForm.get('metodoPago').value === method;
    }

    plusCant(idProducto: number) {
        this.carro.producto = { id : idProducto };
        this.carro.cantidad = +1;
        this.sendCant(this.carro);
    }

    minusCant(idProducto: number, cantidad : number) {
        if(cantidad != 1){
            this.carro.producto = { id : idProducto };
            this.carro.cantidad = +(-1);
            this.sendCant(this.carro);
        }
    }

    sendCant(carro : Carro){
        this._cart.saveItem(carro)
        .subscribe(() => {
            this.getProductsById();
        }, badRequest => {
            this._alert.error(badRequest);
        })
    }
}