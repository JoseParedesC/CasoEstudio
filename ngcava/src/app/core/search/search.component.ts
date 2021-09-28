import { Component, OnInit } from "@angular/core";
import { Categoria } from "../models/categoria";
import { CategoriaService } from "../services/categoria.service";

@Component({
    selector: 'app-search',
    templateUrl: './search.component.html',
    styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit{
    categorias: Categoria[] = [];

    constructor(private _categoria: CategoriaService){}

    ngOnInit(){
        this._categoria.getAll()
            .subscribe((response) => {
                console.log(response);
                if(response.status === 200){
                    this.categorias = response.body;
                }
            });
    }
}