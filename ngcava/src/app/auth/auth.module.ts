import { NgModule } from "@angular/core";
import { MaterialModule } from "../material/material.module";
import { SharedModule } from "../shared/shared.module";
import { LoginComponent } from "./login/login.component";
import { AuthService } from "./service/auth.service";
import { SignInComponent } from "./sign-in/sign-in.component";

@NgModule({
    declarations: [
        LoginComponent,
        SignInComponent
    ],
    imports: [
        SharedModule,
        MaterialModule
    ],
    providers: [
        AuthService
    ]
})
export class AuthModule{}