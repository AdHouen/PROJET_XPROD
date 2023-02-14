export class User {

  public id: number;
	public idUser: string;
	public firstName: string;
	public lastName: string;
	public username: string;
	public password: string;
	public email: string;
	public profileImageURL: string;
	public lastLoginDate: Date;
	public lastLoginDateDisplay: Date;
	public joinDate: Date;
	public role: string;
	public authorities: [];
	public isActive: boolean;
	public isNotLocked: boolean;

  constructor(

  ){
    this.id= 0;
    this.idUser= "";
    this.firstName= "";
    this.lastName= "";
    this.username= "";
    this.password= "";
    this.email= "";
    this.profileImageURL= "";
    this.lastLoginDate= new Date();
    this.lastLoginDateDisplay= new Date();
    this.joinDate= new Date();
    this.role= "";
    this.authorities= [];
    this.isActive= true;
    this.isNotLocked= true;
  }

}
