package io.github.myselfshubham1.spring_boot_assignment.blogtest;




import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.myselfshubham1.spring_boot_assignment.controller.BlogController;
import io.github.myselfshubham1.spring_boot_assignment.model.Blog;
import io.github.myselfshubham1.spring_boot_assignment.service.BlogService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BlogController.class)
public class BlogTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BlogService blogService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createBlogPost_ValidData_ReturnsSuccess() throws Exception {
        Blog blog = new Blog(1L, "Title", "Content");

        when(blogService.createBlog(any(Blog.class))).thenReturn(blog);

        mockMvc.perform(post("/create/blog")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(blog)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Title"));
    }

    @Test
    void createBlogPost_InvalidData_ReturnsBadRequest() throws Exception {
        Blog blog = new Blog(); // empty blog

        mockMvc.perform(post("/create/blog")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(blog)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void createBlogPost_NullBlog_ReturnsBadRequest() throws Exception {
        mockMvc.perform(post("/create/blog")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getBlogById_ValidId_ReturnsBlog() throws Exception {
        Blog blog = new Blog(1L, "Test Blog", "Content");
        when(blogService.getBlogById(1L)).thenReturn(blog);

        mockMvc.perform(get("/blog/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Test Blog"));
    }

//    @Test
//    void getBlogById_InvalidId_ThrowsProductNotFoundException() throws Exception {
//        when(blogService.getBlogById(99L)).thenThrow(new ProductNotFoundException("Blog not found"));
//
//        mockMvc.perform(get("/blog/99"))
//                .andExpect(status().isNotFound());
//    }
}
