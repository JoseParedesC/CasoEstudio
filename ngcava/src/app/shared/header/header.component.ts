import { Component } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";

@Component({
    selector: 'shared-header',
    templateUrl: './header.component.html'
})
export class SharedHeaderComponent{
    titleMenu : string = "";
    constructor(private route: ActivatedRoute){
        console.log(this.route);
    }
}