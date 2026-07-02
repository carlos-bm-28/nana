import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PerfilNana } from './perfil-nana';

describe('PerfilNana', () => {
  let component: PerfilNana;
  let fixture: ComponentFixture<PerfilNana>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PerfilNana]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PerfilNana);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
