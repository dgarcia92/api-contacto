package com.cotsoft.apicontactos.controller;

import com.cotsoft.apicontactos.entity.Contacto;
import lombok.AllArgsConstructor;
import com.cotsoft.apicontactos.model.ContactoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("contactos")
@AllArgsConstructor
public class ContactoController {

    private final ContactoRepository contactoRepository;

    @GetMapping
    public List<Contacto> listContacto(){
        return contactoRepository.findAll();
    }
}
