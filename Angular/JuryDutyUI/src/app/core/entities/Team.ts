export class Team {
    teamId: number;
    teamName: string;
    password: string;
    numOfParticipants: number;
  
    constructor(teamId?: number,
                teamName?: string,
                password?: string,
                numOfParticipants?: number) {

        this.teamId             = teamId;
        this.teamName           = teamName;
        this.password           = password;
        this.numOfParticipants  = numOfParticipants;
    }
}