export class User {
    userId: number;
    username: string;
    password: string;
    groupId: string;
    firstName: string;
    lastName: string;
  
    constructor(userId?: number,
                username?: string,
                password?: string,
                groupId?: string,
                firstName?: string,
                lastName?: string) {

        this.userId     = userId;
        this.username   = username;
        this.password   = password;
        this.groupId    = groupId;
        this.firstName  = firstName;
        this.lastName   = lastName;
    }
}