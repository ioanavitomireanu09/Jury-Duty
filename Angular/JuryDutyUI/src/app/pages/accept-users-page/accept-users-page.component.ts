import { Component, OnInit } from '@angular/core';
import { TempUser } from 'src/app/core/entities/TempUser';
import { HttpClient } from 'selenium-webdriver/http';
import { UserService } from 'src/app/core/services/api/user.service';
import { StorageService } from 'src/app/core/services/storage/storage.service';
import { Router, NavigationEnd } from '@angular/router';

@Component({
  selector: 'app-accept-users-page',
  templateUrl: './accept-users-page.component.html',
  styleUrls: ['./accept-users-page.component.scss']
})
export class AcceptUsersPageComponent implements OnInit {

	public tempUsersList: []
	public navigationSubscription;

	constructor(private userService: UserService,private storage: StorageService, private router: Router) {
		this.navigationSubscription = this.router.events.subscribe((e: any) => {
			// If it is a NavigationEnd event re-initalise the component
			if (e instanceof NavigationEnd) {
			  this.getUserRequests();
			}
		});
	}


	ngOnInit() {
		this.getUserRequests();
	}

	ngAfterViewInit(): void {
		//Called after ngAfterContentInit when the component's view has been initialized. Applies to components only.
		//Add 'implements AfterViewInit' to the class.
		this.getUserRequests();
		
	}

	public getUserRequests() {
		this.userService.getUserRequests().then((res: any) => {
			 this.tempUsersList = res;
			 console.log(res)
			 return res;
		});
	}

	public onAcceptUser(user: TempUser) {
		this.userService.acceptUser(user.username).then((res:any) => {
			this.getUserRequests();
		})
	}

	public onDeclineUser(user: TempUser) {
		this.userService.declineUser(user.username).then((res:any) => {
			this.getUserRequests();
		})
	}

	ngOnDestroy() {
		// avoid memory leaks here by cleaning up after ourselves. If we  
		// don't then we will continue to run our initialiseInvites()   
		// method on every navigationEnd event.
		if (this.navigationSubscription) {  
		   this.navigationSubscription.unsubscribe();
		}
	}
}
