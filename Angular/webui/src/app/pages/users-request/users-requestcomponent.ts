import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { LoginService } from "app/services/api/login.service";
import { ApiRequestService } from "app/services/api/api-request.service";


@Component({
	selector   : 's-users-request-pg',
	templateUrl: './users-request.component.html',
    styleUrls  : [ './users-request.scss'],
})

export class UsersRequestComponent implements OnInit {
    
    constructor(
        private router: Router,
        private loginService: LoginService,
        private apiRequest: ApiRequestService) { }

    ngOnInit() {
    }


    settings = {
      columns: {
        id: {
          title: 'ID'
        },
        name: {
          title: 'Full Name'
        },
        username: {
          title: 'User Name'
        },
        email: {
          title: 'Email'
        }
      }
    };

    data = [
      {
        id: 1,
        name: "Leanne Graham",
        username: "Bret",
        email: "Sincere@april.biz"
      },
      {
        id: 2,
        name: "Ervin Howell",
        username: "Antonette",
        email: "Shanna@melissa.tv"
      },
      
      // ... list of items
      
      {
        id: 11,
        name: "Nicholas DuBuque",
        username: "Nicholas.Stanton",
        email: "Rey.Padberg@rosamond.biz"
      }
    ];

}