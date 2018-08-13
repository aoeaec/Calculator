import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs/add/operator/map';
import {Observable} from "rxjs";

@Injectable()
export class appService {

  getApp(operator: string, params:string ) {
    let data = {};
    console.log("going to call web service");


    console.log(params + "params")
    /*success(function(data) {
       $scope.phones = data;
     });*/

    return this.http.get('http://localhost:8080/calculatorV1/' + params).map((res: Response) => res.json());
    /*.subscribe(
          data => this.res = data,
          err => this.logError(err),
          () => console.log('Random Quote Complete' + this.res.valueOf())
        );;*/
    //console.log("Called" + this.res);
    //return this.res;
  }

  getOperations() {
    return this.http.get('http://localhost:8080/calculatorV1/operations').map((res: Response) => res.json());
  }

  constructor(private http: Http) {
  }

  private logError(error: Response | any) {
    console.error('ApiService::handleError', error);
    return Observable.throw(error);
  }

  private isNotANumber(value: string) {
    return Number.isNaN(Number.parseFloat(value) || Number.parseInt(value))
  }
}
