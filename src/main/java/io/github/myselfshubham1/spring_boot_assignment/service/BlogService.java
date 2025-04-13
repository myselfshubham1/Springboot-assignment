package io.github.myselfshubham1.spring_boot_assignment.service;

import io.github.myselfshubham1.spring_boot_assignment.model.Blog;

import java.util.List;

public interface BlogService {
  Blog createBlog(Blog blog) ;

    List<Blog> getAllBlogs() ;

    Blog getBlogById(long id) ;

    Blog updateBlog(long id, Blog blog) ;

    boolean deleteBlog(long id) ;
}
