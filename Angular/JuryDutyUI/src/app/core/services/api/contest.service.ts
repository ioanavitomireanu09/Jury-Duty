import { Injectable } from '@angular/core';
import { StorageService } from '../storage/storage.service';
import { HttpClient } from '@angular/common/http';
import { CrudService } from '../http/crud.service';
import { ContestToInsert } from '../../entities/ContestToInsert';

@Injectable({
  providedIn: 'root'
})
export class ContestService extends CrudService {
	endpoint = '';
	response: string;

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

}
