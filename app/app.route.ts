import {Routes , RouterModule} from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AddbookComponent } from './addbook/addbook.component';

export const appRoutes : Routes = [
    {

        path:'', redirectTo:'home',pathMatch:'full'
    },

    {
        path: 'home' ,component:HomeComponent

    },
    {
        path:'addbook',component:AddbookComponent
    }
];

export const routing = RouterModule.forRoot(appRoutes);