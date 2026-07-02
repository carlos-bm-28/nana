import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CuidadorasDestacadas } from './cuidadoras-destacadas';

describe('CuidadorasDestacadas', () => {
  let component: CuidadorasDestacadas;
  let fixture: ComponentFixture<CuidadorasDestacadas>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CuidadorasDestacadas]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CuidadorasDestacadas);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
