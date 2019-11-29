import { Injectable } from '@angular/core';
import { CrudService } from '../http/crud.service';
import { StorageKey } from '../storage/storage.model';
import { HttpClient } from '@angular/common/http';
import { StorageService } from '../storage/storage.service';
import { User } from '../../entities/User';
import { Contest } from '../../entities/Contest';
const { USER_DATA } = StorageKey;

@Injectable({
	providedIn: 'root'
})
export class ContestService extends CrudService {
	endpoint = '';
	response: any;
	userData: User;

	constructor(http: HttpClient, private storage: StorageService) {
		super(http);
		this.userData = storage.read(USER_DATA) || null;
	}

	public getContests(username?: string): Contest[] {
		this.endpoint = 'get-contests';

		try {
			if(username)
				this.response = this.get(`username: ${username}`).then(res => {
					return res;
				});
			else
				this.response = this.get().then(res => {
					return res;
				});
        } catch (error) {
            console.error('Error during listing contests', error);
            return null;
        }
	}
}
