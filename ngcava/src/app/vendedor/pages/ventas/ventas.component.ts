import { Component, OnInit } from "@angular/core";
import { AlertService } from "src/app/core/services/alert.service";
import { UserService } from "src/app/core/services/user.service";
import { VentaService } from "src/app/core/services/venta.service";
import { Table } from "src/app/shared/models/table";
import { ventaTable } from "../../models/ventaTable";

@Component({
    selector: 'vendedor-ventas',
    templateUrl: './ventas.component.html'
})
export class VentasVendedorComponent implements OnInit{
    ventas : ventaTable[] = [];
    totalElements: number = 0;
    constructor(
        private _venta : VentaService,
        private _user : UserService,
        private _alert : AlertService
    ){}

    ngOnInit(){
        this.getVentas();
    }

    getVentas(){
        this._venta.getVentasByIdVendedor(this._user.getUser().id)
            .subscribe((response) => {
                this.ventas = response.rows;
                this.totalElements = response.elements;
            }, badRequest => {
                this._alert.error(badRequest);
            })
    }
}