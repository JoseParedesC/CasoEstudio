import { NgModule } from "@angular/core";
import { MaterialModule } from "../material/material.module";
import { SharedModule } from "../shared/shared.module";
import { DetailComponent } from "./detail/detail.component";
import { FooterComponent } from "./footer/footer.component";
import { GridProductComponent } from "./grid-product/grid-product.component";
import { HeaderComponent } from "./header/header.component";
import { HomeComponent } from "./home/home.component";
import { LayoutComponent } from "./layout/layout.component";
import { LoginComponent } from "./login/login.component";
import { NotFoundComponent } from "./not-found/not-found.component";
import { ProfileComponent } from "./profile/profile.component";
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
        ProfileComponent,
        NotFoundComponent,
        DetailComponent,
        GridProductComponent
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
        ProfileComponent,
        NotFoundComponent,
        DetailComponent,
        GridProductComponent
    ]
})
export class CoreModule{}