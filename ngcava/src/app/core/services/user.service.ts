import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})
export class UserService{

    setUser(key : string, data: any){
        localStorage.setItem(key, JSON.stringify(data));
    }

    getUser(key : string){
        return JSON.parse(localStorage.getItem(key));
    }

    deleteUser(key : string){
        localStorage.removeItem(key);
    }
}