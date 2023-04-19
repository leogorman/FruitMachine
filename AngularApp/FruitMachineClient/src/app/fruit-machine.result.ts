export interface FruitMachineResult {
  winner: boolean;
  colors: Color[];
  balance: number;
}

export enum Color {
    BLACK = 'BLACK',
    WHITE = 'WHITE',
    GREEN = 'GREEN',
    YELLOW = 'YELLOW',
  }
