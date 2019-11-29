import { Injectable } from '@angular/core';
import { CrudService } from '../core/services/http/crud.service';
import { HttpClient } from '@angular/common/http';
import { StorageService } from '../core/services/storage/storage.service';
import { StorageKey } from '../core/services/storage/storage.model';
import * as jwt_decode from "jwt-decode";
const { AUTH_TOKEN } = StorageKey;
const { USER_DATA } = StorageKey;

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
        this.logout();
        this.endpoint ='authenticate';
        try {
            this.token = (await this.post({ username, password })).token;
            this.storage.save(AUTH_TOKEN, this.token);
            this.storage.save(USER_DATA, jwt_decode(this.token))
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
           return await this.post({ firstName, lastName, groupId, username, password}, 'text');
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
        this.storage.remove(USER_DATA);
    }

    public isLogged(): boolean {
        if (typeof this.token == 'undefined' || this.token == null) {
            return false;
        } else {
            return this.token.length > 0;
        }
    }
}
