import { NgModule } from "@angular/core";
import { MaterialModule } from "../material/material.module";
import { SharedModule } from "../shared/shared.module";
import { DetailComponent } from "../client/detail/detail.component";
import { FooterComponent } from "./footer/footer.component";
import { GridProductComponent } from "./grid-product/grid-product.component";
import { HeaderComponent } from "./header/header.component";
import { HomeComponent } from "./home/home.component";
import { LayoutComponent } from "./layout/layout.component";
import { NotFoundComponent } from "./not-found/not-found.component";
import { ProfileComponent } from "../client/profile/profile.component";
import { SearchComponent } from "./search/search.component";
import { ShoppingCartComponent } from "../client/shopping-cart/shopping-cart.component";

@NgModule({
    declarations: [
        LayoutComponent,
        HeaderComponent,
        HomeComponent,
        FooterComponent,
        NotFoundComponent,
        SearchComponent,
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
        NotFoundComponent,
        SearchComponent,
        GridProductComponent
    ]
})
export class CoreModule{}