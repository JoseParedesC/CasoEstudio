import { Component } from "@angular/core";
import { FormBuilder, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { AlertService } from "../../core/services/alert.service";
import { AuthService } from "../service/auth.service";
import { UserService } from "../../core/services/user.service";

@Component({
    selector: 'app-sign-in',
    templateUrl: './sign-in.component.html',
    styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent{

    constructor(
        private formBuilder: FormBuilder,
        private _auth: AuthService,
        private _alert: AlertService,
        private _user: UserService,
        private router: Router
    ){}

    public signInForm = this.formBuilder.group({
        rol: ['', Validators.required],
        nombre: ['', Validators.required],
        apellido: ['', Validators.required],
        email: ['', Validators.required],
        telefono: ['', Validators.required],
        direccion: ['', Validators.required],
        tipoDocumento: ['', Validators.required],
        nroDocumento: ['', Validators.required],
        password: ['', Validators.required],
        confirmPassword: ['', Validators.required]
    })

    signIn(){
        this._auth.signInUser(this.signInForm.value)
            .subscribe((response : any) => {
                this._user.setUser(response.body.message)
                this._alert.success('Su registro ha sido exitoso');
                this.router.navigateByUrl('/home');
            }, badRequest => {
                this._alert.error(badRequest); 
            })
    }
}