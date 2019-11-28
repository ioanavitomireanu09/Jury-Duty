export class UserGroup {
    groupId: number;
    description: string;
  
    constructor(groupId?: number,
                description?: string) {

        this.groupId        = groupId;
        this.description    = description;
    }
}