import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { AlertService } from "src/app/core/services/alert.service";
import { UserService } from "src/app/core/services/user.service";
import { CategoriaService } from "src/app/core/services/categoria.service";
import { Categoria } from "src/app/core/models/categoria";
import { ActivatedRoute, Router } from "@angular/router";
import { CurrencyPipe } from '@angular/common';

@Component({
    selector: 'categories-home',
    templateUrl: './categories.component.html'
})
export class CategoriesComponent implements OnInit {
    categorias : any[];
    totalElements: number = 0;
    totalPages: number = 0;
    categoriaForm: FormGroup;
    constructor(
        private _categoria : CategoriaService,
        private _alert : AlertService,
        private formBuilder: FormBuilder
    ){
        this.categoriaForm = this.formBuilder.group({
            id: [0],
            nombre: ['', Validators.required],
        })
    }
    
    submit(){
        const categoria : Categoria = this.categoriaForm.value;
        this._categoria.saveCategoria(categoria).
            subscribe(() => {
                this._alert.success('Se ha guardado la Categoria');
                this.getCategoria();
                document.getElementById('closeModal').click();
            }, badRequest => {
                this._alert.error(badRequest);
            })
    }

    ngOnInit(){
        this.getCategoria();
    }

    getCategoria(){
        this._categoria.getCategoria()
            .subscribe(response => {
                this.categorias = response.rows;
                this.totalPages = response.pages;
                this.totalElements = response.elements;
            })
    }

    deleteCategoria(id : number){
        if(confirm('¿Desea eliminar esta Categoria?')){
            this._categoria.deleteCategoriaById(id)
                .subscribe((response) => {
                    this._alert.success('Categoria eliminado');
                    this.getCategoria();
                }, badRequest => {
                    this._alert.error('Error en el servicio. Intente nuevamente');
                })
        }
    }

    getCategoriaById(id : number){
        this._categoria.getCategoriaById(id)
            .subscribe((response) =>{
                this.categoriaForm.get('id').setValue(response.id);
                this.categoriaForm.get('nombre').setValue(response.nombre);
            })
    }

}

