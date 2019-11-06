import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { LoginService } from "app/services/api/login.service";


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
        private loginService: LoginService) { }

    ngOnInit() {
         // reset login status
         this.loginService.logout(false);
    }

    register() {

        this.loginService.register(this.model)
            .subscribe(resp => {
                    // if (resp.user === undefined || resp.user.token === undefined || resp.user.token === "INVALID" ){
                    //     this.errMsg = 'Username or password is incorrect';
                    //     return;
                    // }
                    this.router.navigate(["/login"]);
                },
                errResponse => {
                  switch(errResponse.status){
                    case 401:
                      this.errMsg = 'Username or password is incorrect';
                      break;
                    case 404:
                      this.errMsg = 'Service not found';
                    case 408:
                      this.errMsg = 'Request Timedout';
                    case 500:
                      this.errMsg = 'Internal Server Error';
                    default:
                      this.errMsg = 'Server Error';
                  }
                }
            );
    }

    onBack() {
        this.router.navigate(["/login"]);
    }

}