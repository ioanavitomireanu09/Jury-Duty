import { Injectable } from '@angular/core';
import { TranslateService } from './translate.service';
import { ApiRequestService } from './api-request.service';
import { Observable, Subject } from 'rxjs';

@Injectable()
export class UserService {

  constructor(
    private apiRequest: ApiRequestService,
    private translate:TranslateService) { }

    getTempUsersInfo(): Observable<any> {
      //Create Request URL params
      let me = this;

      let orderListSubject = new Subject<any>(); // Will use this subject to emit data that we want
      this.apiRequest.get('user-requests')
          .subscribe(jsonResp => {
              let returnObj = jsonResp.items.map(function(v, i, a){
                  let newRow = Object.assign({}, v, {
                      username  : v.username,
                      firstName : v.firstName,
                      lastName  : v.lastName,
                      groupId   : v.groupId
                  });
                  return newRow;
              });
              orderListSubject.next(returnObj); // incidentList is a Subject and emits an event thats being listened to by the components
          });
      return orderListSubject;
  }
}
