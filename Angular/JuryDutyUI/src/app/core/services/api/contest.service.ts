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

	public async getContests(username?: string) {
		this.endpoint = 'get-contests';

		try {
			if(username) {
				this.response = await this.get(`username=${username}`)
				return this.response;
			}
			else {
				this.response = this.get()
				return this.response;
			}

        } catch (error) {
            console.error('Error during listing contests', error);
            return null;
        }
	}

}
