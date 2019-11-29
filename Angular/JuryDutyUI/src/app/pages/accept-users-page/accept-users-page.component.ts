import { Component, OnInit } from '@angular/core';
import { TempUser } from 'src/app/core/entities/TempUser';
import { HttpClient } from 'selenium-webdriver/http';
import { UserService } from 'src/app/core/services/api/user.service';
import { StorageService } from 'src/app/core/services/storage/storage.service';

@Component({
  selector: 'app-accept-users-page',
  templateUrl: './accept-users-page.component.html',
  styleUrls: ['./accept-users-page.component.scss']
})
export class AcceptUsersPageComponent implements OnInit {

	public userService: UserService
	public tempUsersList: any
	public storage: StorageService


	constructor(userService: UserService, storage: StorageService) {
		this.userService = userService;
		this.storage = storage;
	}


	ngOnInit() {
		this.getUserRequests();
	}

	public async getUserRequests() {
		this.tempUsersList = await this.userService.getUserRequests();
	}

}
