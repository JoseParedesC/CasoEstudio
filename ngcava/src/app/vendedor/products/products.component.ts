import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Categoria } from "src/app/core/models/categoria";
import { Table } from "src/app/shared/models/table";
import { AlertService } from "src/app/core/services/alert.service";
import { CategoriaService } from "src/app/core/services/categoria.service";
import { UserService } from "src/app/core/services/user.service";
import { Productos } from "src/app/shared/models/Productos";
import { ProductService } from "src/app/shared/services/producto.service";

@Component({
    selector: 'vendedor-products',
    templateUrl: './products.component.html',
    styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit{
    productos : any[];
    totalElements: number = 0;
    totalPages: number = 0;
    productForm: FormGroup;
    constructor(
        private _producto : ProductService,
        private _user: UserService,
        private _alert : AlertService
    ){}

    ngOnInit(){
        this.getProducts();
    }

    getProducts(){
        const id = this._user.getUser().id;
        this._producto.getProductosByIdvendedor(id)
            .subscribe(response => {
                this.productos = response.rows;
                this.totalPages = response.pages;
                this.totalElements = response.elements;
            })
    }

    deleteProduct(id : number){
        if(confirm('¿Desea eliminar este producto?')){
            this._producto.deleteProductoById(id)
                .subscribe((response) => {
                    this._alert.success('Producto eliminado');
                }, badRequest => {
                    this._alert.error('Error en el servicio. Intente nuevamente');
                })
        }
    }
}