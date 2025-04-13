package io.github.myselfshubham1.spring_boot_assignment.service;

import io.github.myselfshubham1.spring_boot_assignment.model.Blog;

import java.util.List;

public interface BlogService {
  Blog createBlog(Blog blog) ;

    List<Blog> getAllBlogs() ;

    Blog getBlogById(long id) ;

    Blog getBlogByName(String name) ;

    Blog updateBlog(long id, double newPrice) ;

    Blog updateBlogDescription(long id, String newDescription) ;

    boolean deleteBlog(long id) ;
}
