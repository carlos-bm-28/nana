import { TestBed } from '@angular/core/testing';

import { Nana } from './nana';

describe('Nana', () => {
  let service: Nana;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Nana);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
