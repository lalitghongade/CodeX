import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminProblemFormComponent } from './admin-problem-form.component';

describe('AdminProblemFormComponent', () => {
  let component: AdminProblemFormComponent;
  let fixture: ComponentFixture<AdminProblemFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminProblemFormComponent]
    });
    fixture = TestBed.createComponent(AdminProblemFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
