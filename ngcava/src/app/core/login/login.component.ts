import { Component, OnInit} from '@angular/core'
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Auth } from '../models/auth';
import { AlertService } from '../services/alert.service';
import { AuthService } from '../services/auth.service';

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
        private _auth: AuthService,
        private _alert : AlertService
    ){
        this.loginForm = this.formBuilder.group({
            email: ['', Validators.required],
            password: ['', Validators.required],
            rol: ['']
        })
    }

    login(){
        this.loginForm.get('rol').setValue(this.route.snapshot.params.persona);
        this._auth.loginUser(this.loginForm.value)
            .subscribe((response) => {
                console.log(response.body);
            }, badRequest => {
                this._alert.error(badRequest.error);
            })
    }
}