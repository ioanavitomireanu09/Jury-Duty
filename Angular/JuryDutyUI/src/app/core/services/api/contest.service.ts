import { Injectable } from '@angular/core';
import { StorageService } from '../storage/storage.service';
import { HttpClient } from '@angular/common/http';
import { CrudService } from '../http/crud.service';
import { ContestToInsert } from '../../entities/ContestToInsert';
import { Contest } from 'src/app/pages/generaldash/generaldash.component';

@Injectable({
  providedIn: 'root'
})
export class ContestService extends CrudService {
	endpoint = '';
	response: any;


	constructor(http: HttpClient, private storage: StorageService) {
		super(http);
	}

	public async saveEditContest(contest: ContestToInsert) {
		this.endpoint = 'create-contest';
		

		try {
			this.response = await this.post(contest, "text");
			return this.response;
        } catch (error) {
            console.error('Error during accepting user account', error);
            return Promise.reject(error);
        }
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
