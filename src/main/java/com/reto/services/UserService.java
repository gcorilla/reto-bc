package com.reto.services;

import com.reto.controller.UserController;
import com.reto.model.UserModel;
import com.reto.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService{

    //@Autowired
    private final IUserRepository userRepository;

    public UserModel crearUsuario (UserModel userModel){
        //userModel.setTime_up(LocalDateTime.now());
        return userRepository.save(userModel);

    }

    public UserModel actualizarUsuario (Integer id, UserModel usuarioActualizado){
        UserModel usuarioExistente = userRepository.findById(id).orElse(null);

        usuarioExistente.setCellphone(usuarioActualizado.getCellphone());
        usuarioExistente.setName(usuarioActualizado.getName());
        usuarioExistente.setLast_name(usuarioActualizado.getLast_name());
        usuarioExistente.setPassword(usuarioActualizado.getPassword());
        //usuarioExistente.setTime_modify(LocalDateTime.now());

        return userRepository.save(usuarioExistente);
    }

    public void eliminarUsuarioById (Integer id){
        userRepository.deleteById(id);
    }

    public List<UserModel> obtenerTodosLosUsuarios(){
        return userRepository.findAll();
    }

}
