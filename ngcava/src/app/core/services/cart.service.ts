import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";
import { Carro } from "../models/carro";

@Injectable({
    providedIn: 'root'
})
export class CartService{
    url : string = `${ environment.apiUrl }/carrocompra`;
    constructor(private http : HttpClient){}

    saveItem(carro : Carro){
        return this.http.post(this.url, carro);
    }

    deleteItem(id : number){
        return this.http.delete(`${this.url}/${id}`);
    }
}