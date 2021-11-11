import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { catchError } from "rxjs/operators";
import { HandleHttpError } from "src/app/core/utils/HttpError";
import { environment } from '../../../environments/environment';
import { Categoria } from "../models/categoria";
import { Table } from "src/app/shared/models/table";


@Injectable({
    providedIn: 'root'
})
export class CategoriaService{

    constructor(private http: HttpClient){}

    url: string = `${environment.apiUrl}/categorias`;

    getAll(){
        return this.http.get<Categoria[]>(this.url, {observe: 'response'})
            .pipe(catchError(HandleHttpError));
    }

    //POST
    saveCategoria(categoria : Categoria){
        return this.http.post(this.url, categoria)
            .pipe(catchError(HandleHttpError));
    }

    //GET
    getCategoria(){
        return this.http.get<Table>(`${this.url}/table`)
            .pipe(catchError(HandleHttpError));
    }

    getCategoriaById(idCategoria : number){
        return this.http.get<Categoria>(`${this.url}/${idCategoria}`)
            .pipe(catchError(HandleHttpError));
    }

    //DELETE
    deleteCategoriaById(id: number){
        return this.http.delete(`${this.url}/${id}`, { observe: 'response' })
            .pipe(catchError(HandleHttpError));
    }
}