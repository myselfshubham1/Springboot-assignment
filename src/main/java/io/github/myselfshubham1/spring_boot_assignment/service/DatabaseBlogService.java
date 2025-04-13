package io.github.myselfshubham1.spring_boot_assignment.service;

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
    public Blog updateBlog(long id, String name) {
        Blog blog = getBlogById(id);  // Retrieve the blog by ID
        blog.setTitle(name);  // Update the title
        blog.setUpdatedAt(LocalDateTime.now());  // Update the updated timestamp
        return blogRepository.save(blog);
    }

    @Override
    public Blog updateBlogDescription(long id, String newDescription) {
        Blog blog = getBlogById(id);  // Retrieve the blog by ID
        blog.setDescription(newDescription);  // Update the description
        blog.setUpdatedAt(LocalDateTime.now());  // Update the updated timestamp
        return blogRepository.save(blog);
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
