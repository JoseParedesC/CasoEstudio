import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './core/home/home.component';
import { LayoutComponent } from './core/layout/layout.component';
import { NotFoundComponent } from './core/not-found/not-found.component';
import { SearchComponent } from './core/search/search.component';

const ROUTES : Routes = [
    {
        path: '',
        component: LayoutComponent,
        children: [
            { path: '', pathMatch: 'full', redirectTo: '/home' },
            { path: 'home', component: HomeComponent },
            { path: 'search', component: SearchComponent }
        ]
    },
    { 
        path: 'vendedor',
        loadChildren: () => import('./vendedor/vendedor.module').then(v => v.VendedorModule)
    },
    { 
        path: 'administrador',
        loadChildren: () => import('./admin/admin.module').then(a => a.AdminModule)
    },
    { path: '**', component: NotFoundComponent }
];

@NgModule({
    imports: [RouterModule.forRoot(ROUTES)],
    exports: [RouterModule]
})
export class AppRoutingModule{}