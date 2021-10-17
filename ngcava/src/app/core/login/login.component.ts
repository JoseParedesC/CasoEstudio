import { Component, OnInit} from '@angular/core'
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Auth } from '../models/auth';
import { AlertService } from '../services/alert.service';
import { AuthService } from '../services/auth.service';
import { UserService } from '../services/user.service';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss']
})
export class LoginComponent{
    loginForm: FormGroup;
    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router, 
        private _auth: AuthService,
        private _alert : AlertService,
        private _user : UserService
    ){
        this.loginForm = this.formBuilder.group({
            email: ['', Validators.required],
            password: ['', Validators.required]
        })
    }

    login(){
        this._auth.loginUser(this.loginForm.value)
            .subscribe((response : any) => {
                const tipoPersona = response.body.usuario['rol'];
                this._user.setUser(response.body);
                if(tipoPersona.toUpperCase() == 'vendedor'.toUpperCase() ||
                    tipoPersona.toUpperCase() == 'administrador'.toUpperCase()){
                    this.router.navigateByUrl(`${tipoPersona.toLowerCase()}/home`);
                }else{
                    this.router.navigateByUrl('/home');
                }
            }, badRequest => {
                this._alert.error(badRequest.error);
            })
    }
}