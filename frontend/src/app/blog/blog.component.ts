import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.css']
})
export class BlogComponent implements OnInit {
  private blogForm: FormGroup;

  constructor() {
  }

  ngOnInit() {
    this.blogForm = BlogComponent.createBlogForm();
  }

  private static createBlogForm():FormGroup {
    return new FormGroup({
      blogTitleField: new FormControl(),
      blogTextArea: new FormControl()
    });
  }
}
