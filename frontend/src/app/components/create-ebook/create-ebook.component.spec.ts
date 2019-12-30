import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {CreateEbookComponent} from './create-ebook.component';

describe('CreateEbookComponent', () => {
  let component: CreateEbookComponent;
  let fixture: ComponentFixture<CreateEbookComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [CreateEbookComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateEbookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
