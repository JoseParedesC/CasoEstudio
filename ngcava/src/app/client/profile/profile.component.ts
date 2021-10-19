import { Component, OnInit } from "@angular/core";
import { UserService } from "../../core/services/user.service";

@Component({
    selector: 'app-profile',
    templateUrl: './profile.component.html',
    styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit{
    user : any;
    constructor(private _user : UserService){}
    
    ngOnInit(){
        this.getUser();
    }

    getUser(){
        this.user = this._user.getUser();
    }

    uploadImg(event : any){
        console.log(event.target.files[0]);
    }
}