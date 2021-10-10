import { Component, OnInit } from "@angular/core";
import { Productos } from "src/app/shared/models/Productos";
import { ProductService } from "src/app/shared/services/producto.service";
import { Categoria } from "../models/categoria";
import { CategoriaService } from "../services/categoria.service";

@Component({
    selector: 'app-search',
    templateUrl: './search.component.html',
    styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit{
    categorias: Categoria[] = [];
    productos: Productos[] = [];
    constructor(
        private _categoria: CategoriaService,
        private _producto : ProductService
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
                console.log(badRequest);
            });
    }

    getProducts(){
        this._producto.getProductos()
            .subscribe(response => {
                this.productos = response;
            })
    }
}