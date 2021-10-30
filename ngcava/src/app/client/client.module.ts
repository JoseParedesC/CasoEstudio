import { NgModule } from "@angular/core";
import { CartService } from "./service/cart.service";
import { MaterialModule } from "../material/material.module";
import { SharedModule } from "../shared/shared.module";
import { DetailComponent } from "./detail/detail.component";
import { ProfileComponent } from "./profile/profile.component";
import { ShoppingCartComponent } from "./shopping-cart/shopping-cart.component";

@NgModule({
    declarations: [
        DetailComponent,
        ProfileComponent,
        ShoppingCartComponent
    ],
    imports: [
        SharedModule,
        MaterialModule
    ],
    providers: [
        CartService
    ]
})
export class ClientModule{}