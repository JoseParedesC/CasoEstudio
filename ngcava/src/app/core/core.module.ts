import { NgModule } from "@angular/core";
import { MaterialModule } from "../material/material.module";
import { SharedModule } from "../shared/shared.module";
import { FooterComponent } from "./footer/footer.component";
import { HeaderComponent } from "./header/header.component";
import { HomeComponent } from "./home/home.component";
import { LayoutComponent } from "./layout/layout.component";
import { LoginComponent } from "./login/login.component";
import { NotFoundComponent } from "./not-found/not-found.component";
import { SearchComponent } from "./search/search.component";
import { SignInComponent } from "./sign-in/sign-in.component";

@NgModule({
    declarations: [
        LayoutComponent,
        HeaderComponent,
        HomeComponent,
        FooterComponent,
        SearchComponent,
        LoginComponent,
        SignInComponent,
        NotFoundComponent
    ],
    imports: [
        SharedModule,
        MaterialModule
    ],
    exports: [
        LayoutComponent,
        HeaderComponent,
        HomeComponent,
        FooterComponent,
        SearchComponent,
        SignInComponent,
        LoginComponent,
        NotFoundComponent
    ]
})
export class CoreModule{}