export class Country {

    /*id!: number;
    name: string;
    officialLanguage!: string;
    climate!: string;
    area!: string;*/

    constructor(private _id: number, private _name: string, private _officialLanguage: string, private _climate: string, private _area: string){
    }

    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }

    public get name(): string {
        return this._name;
    }
    public set name(value: string) {
        this._name = value;
    }

    public get officialLanguage(): string {
        return this._officialLanguage;
    }
    public set officialLanguage(value: string) {
        this._officialLanguage = value;
    }

    public get climate(): string {
        return this._climate;
    }
    public set climate(value: string) {
        this._climate = value;
    }

    public get area(): string {
        return this._area;
    }
    public set area(value: string) {
        this._area = value;
    }

    

}