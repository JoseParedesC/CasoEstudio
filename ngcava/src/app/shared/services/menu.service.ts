import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from '../../../environments/environment';
import { Menus } from "../models/menu";

@Injectable({
    providedIn: 'root'
})
export class MenuService{
    url : string = `${ environment.apiUrl }/menus`;
    constructor(private http: HttpClient){}

    getMenusByTipoRol(rol : string){
        return this.http.get<Menus[]>(`${this.url}/${rol}`);
    }
}