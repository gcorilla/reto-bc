package com.reto.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity(name = "tb_bc_posts")
public class PostModel implements Serializable {
    public static final long serielVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_post;
    private String text;
    private LocalDate time_up;
    private LocalDate time_modify;

    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonProperty("userModel")
    private UserModel userModel;
}
