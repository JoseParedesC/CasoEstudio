import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { catchError } from "rxjs/operators";
import { HandleHttpError } from "src/app/core/utils/HttpError";
import { environment } from "src/environments/environment";
import { Auth } from "../models/auth";

@Injectable()
export class AuthService{
    url: string = `${environment.apiUrl}/auth`;

    constructor(private http: HttpClient){}

    signInUser(user: Auth){
        return this.http.post(this.url, user, { observe: 'response' })
            .pipe(catchError(HandleHttpError));
    }

    loginUser(user: Auth){
        return this.http.post(`${this.url}/login`, user, { observe: 'response' })
            .pipe(catchError(HandleHttpError));
    }
}