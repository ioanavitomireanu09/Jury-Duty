import { Injectable } from '@angular/core';
import { CrudService } from '../http/crud.service';
import { StorageKey } from '../storage/storage.model';
import { HttpClient } from '@angular/common/http';
import { StorageService } from '../storage/storage.service';
import { User } from '../../entities/User';
const { USER_DATA } = StorageKey;

@Injectable({
	providedIn: 'root'
})
export class UserService extends CrudService {
	endpoint = '';
	response: string;
	userData: User;
	constructor(http: HttpClient, private storage: StorageService) {
		super(http);
		this.userData = storage.read(USER_DATA) || null;
	}

	public async getUserRequests() {
		this.endpoint = 'user-requests';
		try {
			this.response = await this.get();
			return this.response;
        } catch (error) {
            console.error('Error during listing users', error);
            return Promise.reject(error);
        }
	}

	public async acceptUser(user: User) {
		this.endpoint = 'accept-user';

		try {
			this.response = await this.post(user.username);
			return this.response;
        } catch (error) {
            console.error('Error during accepting user account', error);
            return Promise.reject(error);
        }
	}

	public async declineUser(user: User) {
		this.endpoint = 'decline-user';

		try {
			this.response = await this.post(user.username);
			return this.response;
        } catch (error) {
            console.error('Error during declining user account', error);
            return Promise.reject(error);
        }
	}

	public async getUserGroups(user: User) {
		this.endpoint = 'user-groups';

		try {
			this.response = await this.get();
			return this.response;
        } catch (error) {
            console.error('Error during listing user groups', error);
            return Promise.reject(error);
        }
	}
}
