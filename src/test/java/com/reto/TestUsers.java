package com.reto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.reto.model.PostModel;
import com.reto.model.UserModel;
import org.junit.jupiter.api.Test;

public class TestUsers {

    @Test
    public void testUserEntity() {
        UserModel user = new UserModel();
        user.setId_user(1);
        user.setName("nombre");
        user.setLast_name("apellido");
        user.setCellphone("123456789");
        user.setPassword("password");

        assertEquals(1, user.getId_user().intValue());
        assertEquals("nombre", user.getName());
        assertEquals("apellido", user.getLast_name());
        assertEquals("123456789", user.getCellphone());
        assertEquals("password", user.getPassword());
    }

    @Test
    public void testPostEntity() {
        // Crear un post
        PostModel post = new PostModel();
        post.setId_post(1);
        post.setText("text");


        assertEquals(1, post.getId_post());
        assertEquals("text", post.getText());
    }
}
