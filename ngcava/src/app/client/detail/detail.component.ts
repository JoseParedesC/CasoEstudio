import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Productos } from "src/app/shared/models/Productos";
import { ProductService } from "src/app/shared/services/producto.service";

@Component({
    selector: 'app-detail',
    templateUrl: './detail.component.html',
    styleUrls: ['./detail.component.scss']
})
export class DetailComponent implements OnInit{
    producto : Productos;
    cantitad : number = 0;
    id: number = 0;
    constructor(
        private _producto : ProductService,
        private route : ActivatedRoute
    ){
        this.id = +this.route.snapshot.params.id;
    }

    ngOnInit(){
        this.getProductDetail();
    }

    getProductDetail(){
        this._producto.getProductById(this.id)
            .subscribe(data => this.producto = data.body);
    }

    plusCant(){
        this.cantitad++;
    }

    minusCant(){
        if(this.cantitad != 0){
            this.cantitad--;
        }
    }
}