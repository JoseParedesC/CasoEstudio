import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { catchError } from "rxjs/operators";
import { HandleHttpError } from "src/app/core/utils/HttpError";
import { environment } from "src/environments/environment";
import { Carro } from "../models/carro";
import { carroCompraGet } from "../models/carroGet";

@Injectable()
export class CartService{
    url : string = `${ environment.apiUrl }/carrocompra`;
    constructor(private http : HttpClient){}

    saveItem(carro : Carro){
        return this.http.post(this.url, carro)
            .pipe(catchError(HandleHttpError));
    }

    deleteItem(id : number, idCarro : number){
        return this.http.delete(`${this.url}/${id}/carro${idCarro}`)
            .pipe(catchError(HandleHttpError));
    }

    getProductsByIdCarroCompra(id : number){
        return this.http.get<carroCompraGet>(`${this.url}/${id}`)
            .pipe(catchError(HandleHttpError));
    }
}