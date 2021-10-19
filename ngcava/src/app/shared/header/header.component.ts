import { Component } from "@angular/core";
import { Router } from "@angular/router";

@Component({
    selector: 'shared-header',
    templateUrl: './header.component.html'
})
export class SharedHeaderComponent{
    title : string = "";
    constructor(private route: Router){
        this.title = this.route.url.split('/')[2]; 
    }
}