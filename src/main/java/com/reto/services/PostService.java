package com.reto.services;

import com.reto.model.PostModel;
import com.reto.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private IPostRepository iPostRepository;

public PostModel crearPost (PostModel postModel){
    //postModel.setTime_up(LocalDateTime.now());
    return iPostRepository.save(postModel);
}

public PostModel actualizarPost (Integer id, PostModel postActualizado){
    PostModel postexistente = iPostRepository.findById(id).orElse(null);

    postexistente.setText(postActualizado.getText());
    //postexistente.setTime_modify(LocalDateTime.now());

    return iPostRepository.save(postexistente);
}

public void eliminarPostById (Integer id){
    iPostRepository.deleteById(id);
}

public List<PostModel> obtenerTodosLosPost(){
        return iPostRepository.findAll();
    }

    public Optional<PostModel> obtenerPostById(Integer id){
    return iPostRepository.findById(id);
    }

}
