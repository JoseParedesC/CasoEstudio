import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DetailComponent } from './client/detail/detail.component';
import { HomeComponent } from './core/home/home.component';
import { LayoutComponent } from './core/layout/layout.component';
import { LoginComponent } from './auth/login/login.component';
import { NotFoundComponent } from './core/not-found/not-found.component';
import { ProfileComponent } from './client/profile/profile.component';
import { SearchComponent } from './core/search/search.component';
import { ShoppingCartComponent } from './client/shopping-cart/shopping-cart.component';
import { SignInComponent } from './auth/sign-in/sign-in.component';

const ROUTES : Routes = [
    {
        path: '',
        component: LayoutComponent,
        children: [
            { path: 'home', component: HomeComponent },
            { path: 'search', component: SearchComponent },
            { path: 'profile', component: ProfileComponent },
            { path: 'detail/:id', component: DetailComponent },
            { path: 'cart', component: ShoppingCartComponent },
            { path: '', redirectTo: '/home', pathMatch: 'full' },
        ]
    },
    { path: 'login', component: LoginComponent },
    { path: 'sign-in', component: SignInComponent },
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
    imports: [RouterModule.forRoot(ROUTES, { useHash: true })],
    exports: [RouterModule]
})
export class AppRoutingModule{}