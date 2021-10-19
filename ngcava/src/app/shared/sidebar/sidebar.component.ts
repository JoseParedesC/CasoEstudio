import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Subject } from "rxjs";
import { Menus } from "../models/menu";
import { MenuService } from "../services/menu.service";

@Component({
    selector: 'shared-sidebar',
    templateUrl: './sidebar.component.html'
})
export class SharedSidebarComponent implements OnInit{
    rol : string = "";
    menus: Menus[] = [];
    constructor(
        private route : Router,
        private _menu : MenuService
    ){
        this.rol = this.route.url.split('/')[1];
    }

    ngOnInit(){
        this.getMenus();
    }

    getMenus(){
        this._menu.getMenusByTipoRol(this.rol)
            .subscribe(response => this.menus = response);
    }
}