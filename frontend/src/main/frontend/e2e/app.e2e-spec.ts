import { CalculatorUI } from './app.po';

describe('calculator App', () => {
  let page: CalculatorUI;

  beforeEach(() => {
    page = new CalculatorUI();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
