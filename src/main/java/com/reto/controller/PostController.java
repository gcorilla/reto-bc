package com.reto.controller;

import com.reto.model.PostModel;
import com.reto.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/save")
    public ResponseEntity<?> guardarPost(@RequestBody PostModel postModel){
        postService.crearPost(postModel);
        return ResponseEntity.ok("Post creado exitosamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPostPorId(@PathVariable Integer id){
        postService.eliminarPostById(id);
        return ResponseEntity.ok("Post eliminado exitosamente");
    }

    @GetMapping
    public List<PostModel> getAllPost(){
        return postService.obtenerTodosLosPost();
    }

}
