package com.cotsoft.apicontactos.model;

import com.cotsoft.apicontactos.entity.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepository  extends JpaRepository<Contacto, Long> {
}
