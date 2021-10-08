import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";
import { Auth } from "../models/auth";

@Injectable({
    providedIn: 'root'
})
export class AuthService{
    url: string = `${environment.apiUrl}/auth`;

    constructor(private http: HttpClient){}

    signInUser(user: Auth){
        return this.http.post(this.url, user, { observe: 'response' });
    }

    loginUser(user: Auth){
        return this.http.post(`${this.url}/login`, user, { observe: 'response' });
    }
}