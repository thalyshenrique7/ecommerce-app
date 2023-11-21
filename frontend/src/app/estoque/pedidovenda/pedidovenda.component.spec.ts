import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PedidovendaComponent } from './pedidovenda.component';

describe('PedidovendaComponent', () => {
  let component: PedidovendaComponent;
  let fixture: ComponentFixture<PedidovendaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PedidovendaComponent]
    });
    fixture = TestBed.createComponent(PedidovendaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
