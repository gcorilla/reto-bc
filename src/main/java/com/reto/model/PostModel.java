package com.reto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity(name = "tb_bc_posts")
public class PostModel implements Serializable {
    public static final long serielVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_post;
    private String text;
    @CreationTimestamp
    private LocalDateTime time_up;
    @UpdateTimestamp
    private LocalDateTime time_modify;

    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonProperty("userModel")
    @JsonIgnore
    private UserModel userModel;
}
