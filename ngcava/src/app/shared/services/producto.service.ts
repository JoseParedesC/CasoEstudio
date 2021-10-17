import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Table } from "src/app/core/models/table";
import { environment } from "src/environments/environment";
import { Productos } from "../models/Productos";

@Injectable({
    providedIn: 'root'
})
export class ProductService{
    url : string = `${environment.apiUrl}/productos`;
    constructor(private http: HttpClient){}

    saveProducto(producto : Productos){
        return this.http.post(this.url, producto);
    }

    getProductos(){
        return this.http.get<Productos[]>(this.url);
    }

    searchProducts(nombre : string, idCategoria : number){
        if(idCategoria !== 0){
            return this.http.get<Productos[]>(`${this.url}/search?categoria=${idCategoria}`);
        }
        return this.http.get<Productos[]>(`${this.url}/search?nombre=${nombre}`);
    }

    getProductosByIdvendedor(idVendedor : string){
        return this.http.get<Table>(`${this.url}/vendedor/${idVendedor}`);
    }

    getProductById(id : number){
        return this.http.get<Productos>(`${this.url}/${id}`, { observe: 'response' });
    }

    deleteProductoById(id: number){
        return this.http.delete(`${this.url}/${id}`, { observe: 'response' });
    }
}