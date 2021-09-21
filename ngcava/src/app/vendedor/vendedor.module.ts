import { NgModule } from "@angular/core";
import { SharedModule } from "../shared/shared.module";
import { VendedorRoutingModule } from "./vendedor-routing.module";

@NgModule({
    declarations: [],
    imports: [
        SharedModule,
        VendedorRoutingModule
    ]
})
export class VendedorModule{}