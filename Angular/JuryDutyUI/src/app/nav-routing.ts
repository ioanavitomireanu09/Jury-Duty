import { Route, Router } from '@angular/router';
import { Injectable } from '@angular/core';
import { StorageService } from './core/services/storage/storage.service';
import { StorageKey } from './core/services/storage/storage.model';
import { User } from './core/entities/User';

export interface NavRoute extends Route {
    path?: string;
    icon?: string;
    group?: string;
    groupedNavRoutes?: NavRoute[];
}

export const sideNavPath = 'nav';
const { USER_DATA } = StorageKey;

export const navRoutes: NavRoute[] = [
    {
        data: { title: 'General' },
        icon: 'dashboard',
        path: 'general',
        loadChildren: () =>
            import('./pages/generaldash/generaldash.module').then(
                m => m.GeneraldashModule,
            ),
    },
    {
        data: { title: 'Dashboard' },
        icon: 'dashboard',
        path: 'dashboard',
        loadChildren: () =>
            import('./pages/dashboard/dasboard.module').then(
                m => m.DashboardModule,
            ),
    },
    {
        data: { title: 'Home' },
        icon: 'home',
        path: 'home',
        loadChildren: () =>
            import('./pages/home-page/home-page.module').then(
                m => m.HomePageModule,
            ),
    },
    {
        path: '',
        redirectTo: 'general',
        pathMatch: 'full',
    },
    {
        data: {title: 'AcceptUsers'},
        icon: 'menu',
        group: '',
        path: 'accept-users',
        loadChildren: () =>
            import('./pages/accept-users-page/accept-users-page.module').then(
                m => m.AcceptUsersPageModule,
            ),
    },
    {
        data: {title: 'JuryBoard'},
        icon: 'work',
        group: '',
        path: 'app-jurydash',
        loadChildren: () =>
            import('./pages/jurydash/jurydash.module').then(
                m => m.JurydashModule,
            ),
    },
];



@Injectable({
    providedIn: 'root',
})
export class NavRouteService {
    navRoute: Route;
    navRoutes: NavRoute[];
    userData: User;
    hashMap = {
        "ADM": ['JuryBoard', 'AcceptUsers', 'Home', 'Dashboard', 'General'],
        "ORG": ['JuryBoard', 'Home', 'Dashboard', 'General'],
        "JRT": ['JuryBoard', 'Home', 'General'], 
        "SPEC": ['Home', 'General']
    };
    pagesList = [];

    constructor(router: Router, private storage: StorageService) {
        this.userData = this.storage.read(USER_DATA).userDetails || null;
        this.pagesList = this.hashMap[`${this.userData.groupId}`];

        this.navRoute = router.config.find(route => route.path === sideNavPath);
        this.navRoutes = this.navRoute.children
            .filter(route => (route.data && route.data.title && !this.userData) || (route.data && route.data.title && this.pagesList && this.pagesList.includes(route.data.title)))
            .reduce((groupedList: NavRoute[], route: NavRoute) => {
                if (route.group) {
                    const group: NavRoute = groupedList.find(navRoute => {
                        return (
                            navRoute.group === route.group &&
                            navRoute.groupedNavRoutes !== undefined
                        );
                    });
                    if (group) {
                        group.groupedNavRoutes.push(route);
                    } else {
                        groupedList.push({
                            group: route.group,
                            groupedNavRoutes: [route],
                        });
                    }
                } else {
                    groupedList.push(route);
                }
                return groupedList;
            }, []);
    }

    public getNavRoutes(): NavRoute[] {
        return this.navRoutes;
    }
}
