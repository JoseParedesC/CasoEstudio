import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { ProductoForm } from "./forms/products/products.form";
import { VendedorHomeComponent } from "./home/home.component";
import { VendedorLayoutComponent } from "./layout/layout.component";
import { ProductsComponent } from "./pages/products/products.component";
import { VentasVendedorComponent } from "./pages/ventas/ventas.component";

const ROUTES : Routes = [
    {
        path: '',
        component: VendedorLayoutComponent,
        children: [
            { path: '', redirectTo: '/home', pathMatch: 'full' },
            { path: 'home', component: VendedorHomeComponent },
            { path: 'products', component: ProductsComponent },
            { path: 'ventas', component: VentasVendedorComponent }
        ]
    },
    { path: 'products/form', component: ProductoForm },
    { path: 'products/form/:id', component: ProductoForm }
];

@NgModule({
    imports: [RouterModule.forChild(ROUTES)],
    exports: [RouterModule]
})
export class VendedorRoutingModule{}