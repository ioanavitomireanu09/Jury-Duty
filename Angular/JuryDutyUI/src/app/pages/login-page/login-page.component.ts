import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../auth/auth.service';
import { Router } from '@angular/router';

@Component({
    selector: 'app-login-page',
    templateUrl: './login-page.component.html',
    styleUrls: ['./login-page.component.scss'],
})
export class LoginPageComponent implements OnInit {
    firstName: string;
    lastName: string;
    group: string;
    username: string;
    password: string;
    successMessage: string;
    errorMessage: string;
    showLogin:true;

    constructor(private authService: AuthService, private router: Router) {}

    ngOnInit() {
        this.errorMessage = '';
        if (this.authService.isLogged()) {
            this.navigateTo();
        }
    }

    public async login(username: string, password: string) {
        try {
            const url = await this.authService.login(
                username,
                password,
                );
            this.navigateTo(url);
        } catch (e) {
            this.errorMessage = 'Wrong Credentials!';
            console.error('Unable to Login!\n', e);
        }
    }

    public async register(firstName: string, lastName: string, group: string, username: string, password: string) {
        try {
            const status = await this.authService.register(
                firstName,
                lastName,
                group,
                username,
                password
                );
            switch (status) {
                case 'SAVE':
                case 'WAIT':
                    this.successMessage = status
                    break;
                case 'EXIT':
                    this.errorMessage = 'The user already exists'
                    
                default:
                    break;
            }
        } catch (e) {
            this.errorMessage = 'Wrong Credentials!';
            console.error('Unable to Login!\n', e);
        }
    }

    public navigateTo(url?: string) {
        url = url || 'nav';
        this.router.navigate([url], { replaceUrl: true });
    }
}
