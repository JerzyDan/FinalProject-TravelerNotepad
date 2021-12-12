export class PlaceRequest {

    constructor(private id: number,
        private name: string,
        private city: string,
        private daysNeeded: number,
        private status: string,
        private description: string,
        private countryId: number) {}
}