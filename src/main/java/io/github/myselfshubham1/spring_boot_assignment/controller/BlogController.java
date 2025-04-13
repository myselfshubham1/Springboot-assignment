package io.github.myselfshubham1.spring_boot_assignment.controller;


import io.github.myselfshubham1.spring_boot_assignment.model.Blog;
import io.github.myselfshubham1.spring_boot_assignment.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/blogs")
public class BlogController {

    @Autowired
    public  BlogService blogService;



    @Autowired
    public BlogController( BlogService blogService) {
        this.blogService = blogService;
    }

    // Create a new blog post
    @PostMapping("/create/blog")
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
        Blog createBlog = blogService.createBlog(blog);
        return ResponseEntity.ok(createBlog);
    }

    //  Update an existing blog post
    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @RequestBody Blog blog) {
        Blog updated = blogService.updateBlog(id, blog);
        return ResponseEntity.ok(updated);
    }

    //  Get a blog post by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
        Blog post = blogService.getBlogById(id);
        return ResponseEntity.ok(post);
    }

    //  Get all blog posts
    @GetMapping("/all")
    public ResponseEntity<List<Blog>> getAllBlogs() {
        return ResponseEntity.ok(blogService.getAllBlogs());
    }


    //  Delete a blog post
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBlog(@PathVariable Long id) {
        if (blogService.getBlogById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Blog not found with  id ");
        }

        blogService.deleteBlog(id);
        return ResponseEntity.ok("Blog post deleted successfully.");
    }

}
