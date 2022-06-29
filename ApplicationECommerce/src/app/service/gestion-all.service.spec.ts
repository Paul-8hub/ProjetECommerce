import { TestBed } from '@angular/core/testing';

import { GestionAllService } from './gestion-all.service';

describe('GestionAllService', () => {
  let service: GestionAllService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GestionAllService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
