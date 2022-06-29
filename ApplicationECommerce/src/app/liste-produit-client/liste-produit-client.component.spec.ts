import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeProduitClientComponent } from './liste-produit-client.component';

describe('ListeProduitClientComponent', () => {
  let component: ListeProduitClientComponent;
  let fixture: ComponentFixture<ListeProduitClientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListeProduitClientComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListeProduitClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
