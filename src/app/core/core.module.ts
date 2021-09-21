import { NgModule } from "@angular/core";
import { SharedModule } from "../shared/shared.module";
import { FooterComponent } from "./footer/footer.component";
import { HeaderComponent } from "./header/header.component";
import { HomeComponent } from "./home/home.component";
import { NotFoundComponent } from "./not-found/not-found.component";

@NgModule({
    declarations: [
        HeaderComponent,
        HomeComponent,
        FooterComponent,
        NotFoundComponent
    ],
    imports: [
        SharedModule
    ],
    exports: [
        HeaderComponent,
        HomeComponent,
        FooterComponent,
        NotFoundComponent
    ]
})
export class CoreModule{}