import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NanaDashboard } from './nana-dashboard';

describe('NanaDashboard', () => {
  let component: NanaDashboard;
  let fixture: ComponentFixture<NanaDashboard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NanaDashboard]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NanaDashboard);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
