import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {EditEbookComponent} from './edit-ebook.component';

describe('EditEbookComponent', () => {
  let component: EditEbookComponent;
  let fixture: ComponentFixture<EditEbookComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [EditEbookComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditEbookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
