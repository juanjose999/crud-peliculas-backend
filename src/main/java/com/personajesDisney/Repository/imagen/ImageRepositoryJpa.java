package com.personajesDisney.Repository.imagen;

import com.personajesDisney.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepositoryJpa extends JpaRepository<Image, Long> {
}
