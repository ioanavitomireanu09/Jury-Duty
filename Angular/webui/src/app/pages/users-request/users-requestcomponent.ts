import { Component, OnInit, ViewChild, TemplateRef } from "@angular/core";
import { Router, ActivatedRoute, Params } from "@angular/router";
import { LoginService } from "app/services/api/login.service";
import { ApiRequestService } from "app/services/api/api-request.service";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { OrderService } from "app/services/api/order.service";
import { UserService } from "app/services/api/user.service";


@Component({
	selector   : 's-users-request-pg',
	templateUrl: './users-request.component.html',
    styleUrls  : [ './users-request.scss'],
})

export class UsersRequestComponent implements OnInit {
  @ViewChild('orderStatusCellTpl') statusCellTpl: TemplateRef<any>;
    @ViewChild('orderIdTpl') orderIdTpl: TemplateRef<any>;
    columns:any[];
    rows:any[];
    isLoading:boolean=false;
    constructor(private router: Router, private orderService: UserService) { }

    ngOnInit() {
        var me = this;
        me.getPageData();
        this.columns=[
            {prop:"username"   , name: "Username"           , width:65, cellTemplate: this.orderIdTpl   },
            {prop:"firstName"  , name: "First Name"         , width:105 },
            {prop:"lastName"   , name: "Last Name"          , width:85, cellTemplate: this.statusCellTpl },
            {prop:"groupId"    , name: "Group"              , width:150 }
        ];
    }

    getPageData() {
        var me = this;
        let legendColors = {"On Hold":'#ef2e2e', "Shipped":'#ff8e28', "Complete":'#61c673', "New":'#007cbb'};
        me.isLoading=true;
        me.orderService.getTempUsersInfo()
        .subscribe(function(tempUsersData){
            me.rows = tempUsersData;
            me.isLoading=false;
            console.log("Got Order Data");
        })
    }
}