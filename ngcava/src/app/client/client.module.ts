import { NgModule } from "@angular/core";
import { CartService } from "./service/cart.service";
import { MaterialModule } from "../material/material.module";
import { SharedModule } from "../shared/shared.module";
import { DetailComponent } from "./detail/detail.component";
import { GridProductComponent } from "./grid-product/grid-product.component";
import { ProfileComponent } from "./profile/profile.component";
import { SearchComponent } from "./search/search.component";
import { ShoppingCartComponent } from "./shopping-cart/shopping-cart.component";

@NgModule({
    declarations: [
        DetailComponent,
        GridProductComponent,
        ProfileComponent,
        SearchComponent,
        ShoppingCartComponent
    ],
    imports: [
        SharedModule,
        MaterialModule
    ],
    exports: [
        DetailComponent,
        GridProductComponent,
        ProfileComponent,
        SearchComponent,
        ShoppingCartComponent
    ],
    providers: [
        CartService
    ]
})
export class ClientModule{}