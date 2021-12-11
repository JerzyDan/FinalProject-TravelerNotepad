export class Place {
    /*id: number,
    name: string,
    city: string,
    daysNeeded: number,
    status: number,
    description: string,
    countryId: number*/

    constructor(private _id: number,
        private _name: string,
        private _city: string,
        private _daysNeeded: number,
        private _status: number,
        private _description: string,
        private _countryId: number) {}

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

    public get city(): string {
        return this._city;
    }
    public set city(value: string) {
        this._city = value;
    }

    public get daysNeeded(): number {
        return this._daysNeeded;
    }
    public set daysNeeded(value: number) {
        this._daysNeeded = value;
    }

    public get status(): number {
        return this._status;
    }
    public set status(value: number) {
        this._status = value;
    }

    public get description(): string {
        return this._description;
    }
    public set description(value: string) {
        this._description = value;
    }

    public get countryId(): number {
        return this._countryId;
    }
    public set countryId(value: number) {
        this._countryId = value;
    }
}