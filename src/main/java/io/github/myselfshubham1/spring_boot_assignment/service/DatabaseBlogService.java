package io.github.myselfshubham1.spring_boot_assignment.service;

import io.github.myselfshubham1.spring_boot_assignment.exceptions.ProductNotFoundException;
import io.github.myselfshubham1.spring_boot_assignment.model.Blog;
import io.github.myselfshubham1.spring_boot_assignment.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * implementation of blog service
 */


@Service
public class DatabaseBlogService implements BlogService {


    @Autowired
    public BlogRepository blogRepository;


    public DatabaseBlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    /**
     * full body function to create blog
     */

    @Override
    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);    }

    /**
     * full body function to get all  blogs
     */

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    /**
     * full body function to get blog by ID
     */

    @Override
    public Blog getBlogById(long id) {
        return blogRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog not found with ID: " + id));  // Throw exception if not found
    }


    /**
     * full body function to update  blog
     */



    @Override
    public Blog updateBlog(long id, Blog blog) {
        if (blog.getId() != id) {
            throw new ProductNotFoundException("Product not found with ID: " + id);
        }

        Blog updatedBlog = blogRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Blog with id " + id + " not found"));

        updatedBlog.setTitle(blog.getTitle());
        updatedBlog.setDescription(blog.getDescription());
        updatedBlog.setUpdatedAt(blog.getUpdatedAt());

        return blogRepository.save(updatedBlog);
    }

    /**
     * full body function to delete blog
     */


    @Override
    public boolean deleteBlog(long id) {
        if (blogRepository.existsById(id)) {
            blogRepository.deleteById(id);  // Delete blog by ID
            return true;
        }
        return false;
    }
}
