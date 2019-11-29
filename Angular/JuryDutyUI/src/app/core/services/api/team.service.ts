import { Injectable } from '@angular/core';
import { CrudService } from '../http/crud.service';
import { StorageKey } from '../storage/storage.model';
import { HttpClient } from '@angular/common/http';
import { StorageService } from '../storage/storage.service';
import { User } from '../../entities/User';
import { Team } from '../../entities/Team';
const { USER_DATA } = StorageKey;


@Injectable({
	providedIn: 'root'
})
export class TeamService extends CrudService {
	endpoint = '';
	response: any;
	userData: User;

	constructor(http: HttpClient, private storage: StorageService) {
		super(http);
		this.userData = storage.read(USER_DATA) || null;
	}

	public async getTeams(contestId?: number): Promise<Team[]> {
		this.endpoint = 'get-teams';

		try {
			if(contestId)
				this.response = await this.get(`contestId: ${contestId}`);
			else
				this.response = await this.get();
			return this.response;
        } catch (error) {
            console.error('Error during listing teams', error);
            return Promise.reject(error);
        }
	}

	public async getTeamMembers(teamId?: number): Promise<User[]> {
		this.endpoint = 'get-members';

		try {
			if(teamId)
				this.response = await this.get(`teamId: ${teamId}`);
			else
				this.response = await this.get();
			return this.response;
        } catch (error) {
            console.error('Error during listing team members', error);
            return Promise.reject(error);
        }
	}

}
