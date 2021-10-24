import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { AlertService } from "src/app/core/services/alert.service";
import { RouterService } from "src/app/core/services/router.service";
import { UserService } from "src/app/core/services/user.service";
import { Productos } from "src/app/shared/models/Productos";
import { ProductService } from "src/app/shared/services/producto.service";
import { Carro } from "../models/carro";
import { CartService } from "../service/cart.service";

@Component({
    selector: 'app-detail',
    templateUrl: './detail.component.html',
    styleUrls: ['./detail.component.scss']
})
export class DetailComponent implements OnInit{
    producto : Productos;
    cantitad : number = 0;
    id: number = 0;
    constructor(
        private _producto : ProductService,
        private route : ActivatedRoute,
        private _router : RouterService,
        private _cart : CartService,
        private _user : UserService,
        private _alert : AlertService
    ){
        this.id = +this.route.snapshot.params.id;
    }

    ngOnInit(){
        this.getProductDetail();
    }

    getProductDetail(){
        this._producto.getProductById(this.id)
            .subscribe(data => this.producto = data.body);
    }

    addToCart(){
        let cart : Carro = { 
            producto: { id : this.id }, 
            carroCompra: { id : this._user.getUser().carro },
            cantidad: this.cantitad
        };
        this._cart.saveItem(cart)
            .subscribe(() => {
                this._alert.success('Producto agregado al carrito de compras');
            }, badRequest => {
                this._alert.error(badRequest);
            });
    }

    plusCant(){
        this.cantitad++;
    }

    minusCant(){
        if(this.cantitad != 0){
            this.cantitad--;
        }
    }

    back(){
        this._router.goBack();
    }
}