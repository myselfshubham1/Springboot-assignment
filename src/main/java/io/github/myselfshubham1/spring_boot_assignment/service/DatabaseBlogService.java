package io.github.myselfshubham1.spring_boot_assignment.service;

import io.github.myselfshubham1.spring_boot_assignment.exceptions.ProductNotFoundException;
import io.github.myselfshubham1.spring_boot_assignment.model.Blog;
import io.github.myselfshubham1.spring_boot_assignment.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DatabaseBlogService implements BlogService {


    public BlogRepository blogRepository;

    public DatabaseBlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }


    @Override
    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public Blog getBlogById(long id) {
        return blogRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog not found with ID: " + id));  // Throw exception if not found
    }



    @Override
    public Blog updateBlog(long id, Blog blog) {

        if (blog.getId() != id) {
            throw new ProductNotFoundException("Product not found with ID: " + id);
        }
        Blog updatedBlog = blogRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Blog with id " + id + " not found"));

        updatedBlog.setTitle(updatedBlog.getTitle());
        updatedBlog.setDescription(updatedBlog.getDescription());
        updatedBlog.setUpdatedAt(updatedBlog.getUpdatedAt());
        return blogRepository.save(updatedBlog);
    }


    @Override
    public boolean deleteBlog(long id) {
        if (blogRepository.existsById(id)) {
            blogRepository.deleteById(id);  // Delete blog by ID
            return true;
        }
        return false;
    }
}
