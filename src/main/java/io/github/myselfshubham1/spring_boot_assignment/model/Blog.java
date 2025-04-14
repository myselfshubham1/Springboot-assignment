package io.github.myselfshubham1.spring_boot_assignment.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;


@Entity
    @Table(name="blogs")
    public class Blog {

    /**
     * Auto generated private key as ID
     */

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

    /**
     * field for title
     */

        @NotBlank(message = "blog's title is missing ")
        @Size(min = 3, max = 50, message = "blog title should be at least of 3 characters and maximum of 50 ")
        @Column(nullable = false)
        private String title;

    /**
     * field for description
     */

        @NotBlank(message= "description can't be null")
        @Size(min = 10,max=1000,message = "description should be in 10 to 1000 characters")
        @Column(nullable = false)
        private String description;

    /**
     * field for time at what we create
     */

        @Column
        @CreationTimestamp
        private LocalDateTime createdAt;

    /**
     * field for time at what we updated
     */

        @Column
        @UpdateTimestamp
        private LocalDateTime updatedAt;

    /**
     * blank constructor
     */

        public Blog() {
        }

    /**
     * constructor
     */

        public Blog(LocalDateTime createdAt, String title, String description, LocalDateTime updatedAt) {
            this.createdAt = createdAt;
            this.title = title;
            this.description = description;
            this.updatedAt = updatedAt;
        }

    /**
     * getter and setter
     */

    public Blog(long l, String title, String content) {
    }

    public long getId() {
            return id;
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
            return LocalDateTime.now();
        }

        public void setUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
        }

    /**
     * equals part
     */

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Blog blog = (Blog) o;
        return id == blog.id && Objects.equals(title, blog.title) && Objects.equals(description, blog.description) && Objects.equals(createdAt, blog.createdAt) && Objects.equals(updatedAt, blog.updatedAt);
    }

    /**
     * hashcode part
     */

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, createdAt, updatedAt);
    }

    /**
     * to -string part
     */

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


