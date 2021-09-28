import { NgModule } from "@angular/core";
import { SharedModule } from "../shared/shared.module";
import { AdminRoutingModule } from "./admin-routing.module";
import { AdminHeaderComponent } from "./header/header.component";
import { AdminLayoutComponent } from "./layout/layout.component";
import { AdminSidebarComponent } from "./sidebar/sidebar.component";

@NgModule({
    declarations: [
        AdminLayoutComponent,
        AdminHeaderComponent,
        AdminSidebarComponent
    ],
    imports: [
        SharedModule,
        AdminRoutingModule
    ]
})
export class AdminModule{}