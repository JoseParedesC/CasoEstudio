import { Component, OnInit } from "@angular/core";
import { ProductoGrid } from "src/app/shared/models/ProductoGrid";
import { ProductService } from "src/app/shared/services/producto.service";
import { Categoria } from "../models/categoria";
import { AlertService } from "../services/alert.service";
import { CategoriaService } from "../services/categoria.service";

@Component({
    selector: 'app-search',
    templateUrl: './search.component.html',
    styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit{
    categorias: Categoria[] = [];
    productos: ProductoGrid[] = [];
    nombreProducto : string = "";
    idCategoria: number = 0;
    constructor(
        private _categoria: CategoriaService,
        private _producto : ProductService,
        private _alert : AlertService
    ){}

    ngOnInit(){
        this.getCategorias();
        this.getProducts();
    }

    getCategorias(){
        this._categoria.getAll()
            .subscribe((response) => {
                this.categorias = response.body;
            }, badRequest => {
                this._alert.error(badRequest);
            });
    }

    getProducts(){
        this.idCategoria = this.nombreProducto !== '' ? 0 : this.idCategoria;
        this._producto.searchProducts(this.nombreProducto, this.idCategoria)
            .subscribe(response => {
                this.productos = response
            }, badRequest => {
                this._alert.error(badRequest);
            });
    }

    setCategoria(idCategoria : number){
        this.nombreProducto = "";
        this.idCategoria = idCategoria;
        this.getProducts();
    }
}