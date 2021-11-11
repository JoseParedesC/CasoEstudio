import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { catchError } from "rxjs/operators";
import { Table } from "src/app/shared/models/table";
import { HandleHttpError } from "src/app/core/utils/HttpError";
import { environment } from "src/environments/environment";
import { Categoria } from "../core/models/categoria";

@Injectable({
    providedIn: 'root'
})
export class CategoriaService{
    url : string = `${environment.apiUrl}/categoria`;
    constructor(private http: HttpClient){}

    
}