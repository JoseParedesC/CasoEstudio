import { Component, OnInit } from "@angular/core";
import { ProductoGrid } from "src/app/shared/models/ProductoGrid";
import { ProductService } from "src/app/shared/services/producto.service";
import { AlertService } from "../services/alert.service";

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit{
    productos : ProductoGrid[] = [];
    constructor(
        private _producto : ProductService,
        private _alert : AlertService
    ){}

    ngOnInit(){
        this.getProducts();
    }

    getProducts(){
        this._producto.getTopProducts()
            .subscribe((response) => {
                this.productos = response;
            }, badRequest => {
                this._alert.error(badRequest);
            })
    }
}