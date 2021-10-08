import { Component, OnInit } from "@angular/core";
import { UserService } from "../services/user.service";

@Component({
    selector: 'app-header',
    templateUrl: './header.component.html'
})
export class HeaderComponent implements OnInit{
    name: string = "";
    constructor(private _user: UserService){}
    ngOnInit(){
        this.getUser();    
    }

    logOut(){
        this._user.deleteUser('cliente');
        this.getUser();
    }

    getUser(){
        this.name = !this._user.getUser('cliente') ? '' : this._user.getUser('cliente').nombre;
    }
}