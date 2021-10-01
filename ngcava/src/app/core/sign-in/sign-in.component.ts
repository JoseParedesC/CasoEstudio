import { Component } from "@angular/core";
import { FormBuilder, Validators } from "@angular/forms";
import { AlertService } from "../services/alert.service";
import { AuthService } from "../services/auth.service";

@Component({
    selector: 'app-sign-in',
    templateUrl: './sign-in.component.html',
    styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent{

    constructor(
        private formBuilder: FormBuilder,
        private _auth: AuthService,
        private _alert: AlertService
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
            .subscribe((response) => {
                this._alert.success('Su registro ha sido exitoso');
            }, badRequest => {
                this._alert.error(badRequest.error); 
            })
    }
}