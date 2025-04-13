package io.github.myselfshubham1.spring_boot_assignment.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Blog_Post {
    @Entity
    public class BlogPost {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        private String title;

        @Column(columnDefinition = "TEXT")
        private String content;

        private boolean published;

        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public BlogPost() {
        }

        public BlogPost(LocalDateTime createdAt, long id, String title, String content, boolean published, LocalDateTime updatedAt) {
            this.createdAt = createdAt;
            this.id = id;
            this.title = title;
            this.content = content;
            this.published = published;
            this.updatedAt = updatedAt;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public boolean isPublished() {
            return published;
        }

        public void setPublished(boolean published) {
            this.published = published;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }

        public LocalDateTime getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
        }
    }

}
