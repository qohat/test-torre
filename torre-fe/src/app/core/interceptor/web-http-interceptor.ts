import {HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {NgxSpinnerService} from 'ngx-spinner';
import {Observable, throwError} from 'rxjs';
import {catchError, finalize, map} from 'rxjs/operators';
import {LocalStorageService} from '../service/local-storage.service';

@Injectable()
export class WebHttpInterceptor implements HttpInterceptor {

  constructor(
    private router: Router,
    private readonly spinnerService: NgxSpinnerService,
    private readonly lsService: LocalStorageService) { }

  public intercept(req: HttpRequest<any>, next: HttpHandler): Observable<any> {
    this.spinnerService.show();
    return next.handle(req).pipe(
      map((event: HttpEvent<any>) => {
        return event;
      }),
      catchError((error: HttpErrorResponse) => {
        this.handlerError(error);
        return throwError(error);
      }),
      finalize(() => {
        this.spinnerService.hide();
      }),
    );
  }

  public async handlerError(error: HttpErrorResponse) {
    //this.router.navigateByUrl('/feedback/' + error.status);
  }

}
