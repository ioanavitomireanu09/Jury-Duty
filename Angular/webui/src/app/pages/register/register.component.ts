import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { LoginService } from "app/services/api/login.service";
import { ApiRequestService } from "app/services/api/api-request.service";


@Component({
	selector   : 's-register-pg',
	templateUrl: './register.component.html',
    styleUrls  : [ './register.scss'],
})

export class RegisterComponent implements OnInit {

    model: any = {};
    errMsg:string = '';
    constructor(
        private router: Router,
        private loginService: LoginService,
        private apiRequest: ApiRequestService) { }

    ngOnInit() {
         // reset login status
         this.loginService.logout(false);
    }

    register() { 

      this.apiRequest.post('register', this.model)
            .subscribe(res => {
                    // if (resp.user === undefined || resp.user.token === undefined || resp.user.token === "INVALID" ){
                    //     this.errMsg = 'Username or password is incorrect';
                    //     return;
                    // }
                    switch (res) {
                      case "SAVE":
                          this.router.navigate(["/login"]);
                        break;
                      case "WAIT":
                          this.errMsg = 'You need to wait for approval';
                          break;
                      case "EXIST":
                          this.errMsg = 'The user already exist';
                      default:
                          this.errMsg = 'Server Error';
                        break;
                    }
                }
            );
    }

    onBack() {
        this.router.navigate(["/login"]);
    }

}