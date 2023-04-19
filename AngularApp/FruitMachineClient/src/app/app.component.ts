import { Component } from '@angular/core';
import { FruitMachineResult } from './fruit-machine.result';
import { FruitMachineService } from './app.service';
import { Color } from './fruit-machine.result';

@Component({
  selector: 'app-root',
  template: `
    <button [disabled]="buttonDisabled" (click)="spin()">Spin</button>
    <button (click)="reset()">Reset</button>
    <div *ngIf="result">
      <div>Colors: {{ result.colors }}</div>
      <div>Balance: {{ result.balance }}</div>
      <div *ngIf="result.winner">Winner!</div>
      <div *ngIf="!result.winner">Sorry, you lost.</div>
    </div>
  `,
})
export class AppComponent {

  result: FruitMachineResult | undefined;
  buttonDisabled: boolean = false;

  constructor(private fruitMachineService: FruitMachineService) {}

  spin() {
      this.fruitMachineService.spin().subscribe((result) => {
        this.result = result;
        if(result.balance == 0){
            this.buttonDisabled = true;
        } else{
          this.buttonDisabled = false;
        }
      });
  }

  reset() {
    this.fruitMachineService.reset().subscribe((result) => {
      this.result = result;
      this.buttonDisabled = false;
    });
  }

  getColorName(color: Color) {
    return Color[color];
  }
}
