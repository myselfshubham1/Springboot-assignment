package io.github.myselfshubham1.spring_boot_assignment.service;

import io.github.myselfshubham1.spring_boot_assignment.model.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogService {
  /**
   * function  for creating blog
   */


  Blog createBlog(Blog blog) ;

  /**
   * function to store all blogs
   */


    List<Blog> getAllBlogs() ;
  /**
   * function to get blog by ID
   */

    Blog getBlogById(long id) ;
  /**
   * function to update blog
   */


    Blog updateBlog(long id, Blog blog) ;
  /**
   * function to delete and check it is deleted or not
   */


    boolean deleteBlog(long id) ;
}
