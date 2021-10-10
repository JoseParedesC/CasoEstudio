import { NgModule } from "@angular/core";
import { SharedModule } from "../shared/shared.module";
import { AdminRoutingModule } from "./admin-routing.module";
import { AdminLayoutComponent } from "./layout/layout.component";

@NgModule({
    declarations: [
        AdminLayoutComponent,
    ],
    imports: [
        SharedModule,
        AdminRoutingModule
    ]
})
export class AdminModule{}