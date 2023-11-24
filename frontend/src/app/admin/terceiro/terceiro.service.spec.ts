import { TestBed } from '@angular/core/testing';

import { TerceiroService } from './terceiro.service';

describe('TerceiroService', () => {
  let service: TerceiroService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TerceiroService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
