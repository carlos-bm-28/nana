import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistroNana } from './registro-nana';

describe('RegistroNana', () => {
  let component: RegistroNana;
  let fixture: ComponentFixture<RegistroNana>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegistroNana]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistroNana);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
