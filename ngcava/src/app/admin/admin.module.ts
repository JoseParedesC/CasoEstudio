import { NgModule } from "@angular/core";
import { MaterialModule } from "../material/material.module";
import { SharedModule } from "../shared/shared.module";
import { AdminRoutingModule } from "./admin-routing.module";
import { AdminHomeComponent } from "./home/home.component";
import { AdminLayoutComponent } from "./layout/layout.component";
import { CategoriesComponent } from "./pages/categories/categories.component";

@NgModule({
    declarations: [
        AdminLayoutComponent,
        CategoriesComponent,
        AdminHomeComponent
    ],
    imports: [
        SharedModule,
        AdminRoutingModule,
        MaterialModule
    ]
})
export class AdminModule{}