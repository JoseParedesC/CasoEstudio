import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './core/home/home.component';
import { NotFoundComponent } from './core/not-found/not-found.component';

const ROUTES : Routes = [
    { path: 'home', component: HomeComponent },
    { 
        path: 'vendedor',
        loadChildren: () => import('./vendedor/vendedor.module').then(v => v.VendedorModule)
    },
    { 
        path: 'administrador',
        loadChildren: () => import('./admin/admin.module').then(a => a.AdminModule)
    },
    { path: '', pathMatch: 'full', redirectTo: '/home' },
    { path: '**', component: NotFoundComponent }
];

@NgModule({
    imports: [RouterModule.forRoot(ROUTES)],
    exports: [RouterModule]
})
export class AppRoutingModule{}