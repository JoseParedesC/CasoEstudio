import { NgModule } from "@angular/core";
//Material
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatMenuModule } from '@angular/material/menu';

@NgModule({
    imports: [
        MatInputModule,
        MatSelectModule,
        MatFormFieldModule,
        MatMenuModule
    ],
    exports: [
        MatInputModule,
        MatSelectModule,
        MatFormFieldModule,
        MatMenuModule
    ]
})
export class MaterialModule{}