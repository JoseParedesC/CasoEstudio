import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { catchError } from "rxjs/operators";
import { Compra } from "src/app/client/models/compra";
import { Table } from "src/app/shared/models/table";
import { environment } from "src/environments/environment";
import { HandleHttpError } from "../utils/HttpError";

@Injectable({ providedIn: 'root' })
export class VentaService{
    url : string = `${ environment.apiUrl }/ventas`;
    constructor(private http: HttpClient){}

    //POST
    saveCompra(body : Compra){
        return this.http.post(this.url, body)
            .pipe(catchError(HandleHttpError));
    }

    //GET
    getVentasByIdVendedor(id : number){
        return this.http.get<Table>(`${this.url}/vendedor/${id}`)
            .pipe(catchError(HandleHttpError));
    }
}