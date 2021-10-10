import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})
export class UserService{

    setUser(data: any){
        localStorage.setItem('user', JSON.stringify(data));
    }

    getUser(){
        return JSON.parse(localStorage.getItem('user'));
    }

    deleteUser(){
        localStorage.removeItem('user');
    }
}