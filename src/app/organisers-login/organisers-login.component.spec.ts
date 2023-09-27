import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrganisersLoginComponent } from './organisers-login.component';

describe('OrganisersLoginComponent', () => {
  let component: OrganisersLoginComponent;
  let fixture: ComponentFixture<OrganisersLoginComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [OrganisersLoginComponent]
    });
    fixture = TestBed.createComponent(OrganisersLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
