import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrganisersRegisterComponent } from './organisers-register.component';

describe('OrganisersRegisterComponent', () => {
  let component: OrganisersRegisterComponent;
  let fixture: ComponentFixture<OrganisersRegisterComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [OrganisersRegisterComponent]
    });
    fixture = TestBed.createComponent(OrganisersRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
