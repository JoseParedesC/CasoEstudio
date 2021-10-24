import { Component, OnInit } from "@angular/core";
import { UserService } from "../services/user.service";

@Component({
    selector: 'app-header',
    templateUrl: './header.component.html'
})
export class HeaderComponent implements OnInit{
    isVisible: boolean = false; //Vendedor
    constructor(private _user: UserService){}
    ngOnInit(){
        this.getUser();    
    }

    logOut(){
        this._user.deleteUser();
        this.getUser();
    }

    getUser(){
        if(this._user.getUser()){
            this.isVisible = this._user.getUser().rol.toUpperCase() === 'cliente'.toUpperCase() ? true : false;
        }
    }
}