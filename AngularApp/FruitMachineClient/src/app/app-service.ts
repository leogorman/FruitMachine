import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FruitMachineResult } from './fruit-machine.result';

@Injectable({
  providedIn: 'root'
})
export class FruitMachineService {

  private apiUrl = 'http://localhost:8080/api/machine';

  constructor(private http: HttpClient) { }

  spin(): Observable<FruitMachineResult> {
    return this.http.post<FruitMachineResult>(`${this.apiUrl}`, null);
  }

  reset(): Observable<FruitMachineResult> {
    return this.http.post<FruitMachineResult>(`${this.apiUrl}/reset`, null);
  }
}
