import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProteinProductsComponent } from './protein-products.component';

describe('ProteinProductsComponent', () => {
  let component: ProteinProductsComponent;
  let fixture: ComponentFixture<ProteinProductsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProteinProductsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProteinProductsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
