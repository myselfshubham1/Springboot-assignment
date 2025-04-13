package io.github.myselfshubham1.spring_boot_assignment.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
    @Table(name="blogs")
    public class Blog {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        private String title;

        @Column(columnDefinition = "TEXT")
        private String description;

        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public Blog() {
        }

        public Blog(LocalDateTime createdAt, long id, String title, String description, boolean published, LocalDateTime updatedAt) {
            this.createdAt = createdAt;
            this.id = id;
            this.title = title;
            this.description = description;
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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
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

        @Override
        public String toString() {
            return "Blog_Post{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", content='" + description + '\'' +
                    ", createdAt=" + createdAt +
                    ", updatedAt=" + updatedAt +
                    '}';
        }
    }


