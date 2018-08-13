import {Component, OnInit} from '@angular/core';
import {appService} from "./app.service";
import {Response} from "@angular/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./bootstrap.min.css'],
  providers: [appService]
})
export class AppComponent implements OnInit {
  data = {"operator": "", "op1": " ", "op2": " ", "result": "x", "symbol" : "", "error":"", "readyToFetch":false};
  entries = [{"operation": "", "arguments": "", "symbol": " ", "description": "", "op1": "", "op2": ""}]

  constructor(private _appService: appService) {
  }

  ngOnInit() {
    this._appService.getOperations().subscribe(res => this.entries = res, error => this.handle(error),
      () => console.log("entries are" + this.entries));
  }

  calculate(symbol:string, operator: string, param1: string, param2: string): void {
    this.data.operator = operator;
    this.data.op1 = param1;
    this.data.op2 = param2;
    this.data.symbol = symbol;
    this.data.error = "";
    this.data.readyToFetch = false;

    if (this.isNotANumber(param1)) {
      this._appService.getApp(operator, operator).subscribe(res => {this.data.result = res.result; this.data.readyToFetch=true}, error => this.handle(error),
        () => console.log(this.data.result));
    }
    else if (this.isNotANumber(param2)) {
      this._appService.getApp(operator, operator + "?op1=" + param1).subscribe(res => {this.data.result = res.result; this.data.readyToFetch=true}, error => this.handle(error),
        () => console.log(this.data.result));
    }
    else {
      this._appService.getApp(operator, operator + "?op1=" + param1 + "&op2=" + param2).subscribe(res => {this.data.result = res.result; this.data.readyToFetch=true}, error => this.handle(error),
        () => console.log(this.data.result));

    }
  }

  isNotANumber(value: string) {
    return Number.isNaN(Number.parseFloat(value))
  }

  private handle(error: Response | any) {
console.log("Handling error" + error._body);
    this.data.operator = "";
    this.data.op1 = "";
    this.data.op2 = "";
    this.data.symbol = "";
    this.data.result = error._message;
    this.data.error = error._body;
    this.data.readyToFetch = true;
  }

}


