import { Injectable } from '@angular/core';
import { CrudService } from '../core/services/http/crud.service';
import { HttpClient } from '@angular/common/http';
import { StorageService } from '../core/services/storage/storage.service';
import { StorageKey } from '../core/services/storage/storage.model';
const { AUTH_TOKEN } = StorageKey;

@Injectable({
    providedIn: 'root',
})
@Injectable({
    providedIn: 'root',
})
export class AuthService extends CrudService {
    endpoint: string;
    token;
    status;
    redirectUrl: string;

    constructor(http: HttpClient, private storage: StorageService) {
        super(http);
        this.token = this.storage.read(AUTH_TOKEN) || '';
    }

    public async login(username: string, password: string) {
        this.endpoint ='authenticate';
        try {
            this.token = await this.post({ username, password });
            this.storage.save(AUTH_TOKEN, this.token);
            return this.redirectUrl;
        } catch (error) {
            console.error('Error during login request', error);
            return Promise.reject(error);
        }
    }
    public async register(firstName: string, lastName: string, groupId: string, username: string, password: string) {
        this.logout();
        this.endpoint ='register';
        try {
            this.status = await this.post({ firstName, lastName, groupId, username, password});
            
            return "login";
        } catch (error) {
            console.error('Error during login request', error);
            return Promise.reject(error);
        }
    }

    public getToken(): string {
        return this.token;
    }

    public logout() {
        this.token = '';
        this.storage.remove(AUTH_TOKEN);
    }

    public isLogged(): boolean {
        if (typeof this.token.token == 'undefined' || this.token.token == null) {
            return false;
        } else {
            return this.token.token.length > 0;
        }
    }
}
