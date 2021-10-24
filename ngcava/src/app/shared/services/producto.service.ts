import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { catchError } from "rxjs/operators";
import { Table } from "src/app/shared/models/table";
import { HandleHttpError } from "src/app/core/utils/HttpError";
import { environment } from "src/environments/environment";
import { ProductoGrid } from "../models/ProductoGrid";
import { Productos } from "../models/Productos";

@Injectable({
    providedIn: 'root'
})
export class ProductService{
    url : string = `${environment.apiUrl}/productos`;
    constructor(private http: HttpClient){}

    //POST
    saveProducto(producto : Productos){
        return this.http.post(this.url, producto)
            .pipe(catchError(HandleHttpError));
    }

    //GET
    getProductos(){
        return this.http.get<Productos[]>(this.url)
            .pipe(catchError(HandleHttpError));
    }

    searchProducts(nombre : string, idCategoria : number){
        if(idCategoria !== 0){
            return this.http.get<ProductoGrid[]>(`${this.url}/search?categoria=${idCategoria}`)
                .pipe(catchError(HandleHttpError));
        }
        return this.http.get<ProductoGrid[]>(`${this.url}/search?nombre=${nombre}`)
            .pipe(catchError(HandleHttpError));
    }

    getProductosByIdvendedor(idVendedor : string){
        return this.http.get<Table>(`${this.url}/vendedor/${idVendedor}`)
            .pipe(catchError(HandleHttpError));
    }

    getProductById(id : number){
        return this.http.get<Productos>(`${this.url}/${id}`, { observe: 'response' })
            .pipe(catchError(HandleHttpError));
    }

    getTopProducts(){
        return this.http.get<ProductoGrid[]>(`${this.url}/top`)
            .pipe(catchError(HandleHttpError));
    }

    //DELETE
    deleteProductoById(id: number){
        return this.http.delete(`${this.url}/${id}`, { observe: 'response' })
            .pipe(catchError(HandleHttpError));
    }
}