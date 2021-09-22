import { NgModule } from "@angular/core";
import { SharedModule } from "../shared/shared.module";
import { FooterComponent } from "./footer/footer.component";
import { HeaderComponent } from "./header/header.component";
import { HomeComponent } from "./home/home.component";
import { LayoutComponent } from "./layout/layout.component";
import { NotFoundComponent } from "./not-found/not-found.component";
import { SearchComponent } from "./search/search.component";

@NgModule({
    declarations: [
        LayoutComponent,
        HeaderComponent,
        HomeComponent,
        FooterComponent,
        SearchComponent,
        NotFoundComponent
    ],
    imports: [
        SharedModule
    ],
    exports: [
        LayoutComponent,
        HeaderComponent,
        HomeComponent,
        FooterComponent,
        SearchComponent,
        NotFoundComponent
    ]
})
export class CoreModule{}