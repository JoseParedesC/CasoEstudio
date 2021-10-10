import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { RouterModule } from "@angular/router";
import { SharedHeaderComponent } from "./header/header.component";
import { SharedSidebarComponent } from "./sidebar/sidebar.component";

@NgModule({
    declarations: [
        SharedHeaderComponent,
        SharedSidebarComponent
    ],
    imports: [
        CommonModule,
        RouterModule,
        ReactiveFormsModule,
        FormsModule
    ],
    exports: [
        //Modules
        CommonModule,
        RouterModule,
        ReactiveFormsModule,
        FormsModule,
        //Components
        SharedHeaderComponent,
        SharedSidebarComponent
    ]
})
export class SharedModule{}