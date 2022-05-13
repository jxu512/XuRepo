import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FoodcourtComponent } from './foodcourt.component';

describe('FoodcourtComponent', () => {
  let component: FoodcourtComponent;
  let fixture: ComponentFixture<FoodcourtComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FoodcourtComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FoodcourtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
