import { NgModule } from "@angular/core";
//Material
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatFormFieldModule } from '@angular/material/form-field';

@NgModule({
    imports: [
        MatInputModule,
        MatSelectModule,
        MatFormFieldModule
    ],
    exports: [
        MatInputModule,
        MatSelectModule,
        MatFormFieldModule
    ]
})
export class MaterialModule{}