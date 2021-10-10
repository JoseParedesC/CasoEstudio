import { NgModule } from "@angular/core";
//Material
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatMenuModule } from '@angular/material/menu';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from "@angular/material/core";

@NgModule({
    imports: [
        MatInputModule,
        MatSelectModule,
        MatFormFieldModule,
        MatMenuModule,
        MatTableModule,
        MatPaginatorModule,
        MatAutocompleteModule
    ],
    exports: [
        MatInputModule,
        MatSelectModule,
        MatFormFieldModule,
        MatMenuModule,
        MatTableModule,
        MatPaginatorModule,
        MatAutocompleteModule,
    ]
})
export class MaterialModule{}