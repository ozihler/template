import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {InitiativesOverviewComponent} from './initiatives-overview.component';

describe('InitiativesOverviewComponent', () => {
  let component: InitiativesOverviewComponent;
  let fixture: ComponentFixture<InitiativesOverviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [InitiativesOverviewComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InitiativesOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
