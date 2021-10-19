import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})
export class UserService{

    setUser(data: any){
        sessionStorage.setItem('user', JSON.stringify(data));
    }

    getUser(){
        return JSON.parse(sessionStorage.getItem('user'));
    }

    deleteUser(){
        sessionStorage.removeItem('user');
    }
}