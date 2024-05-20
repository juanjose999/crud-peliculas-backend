package com.personajesDisney.entity.dto;

import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ImageDto {
    private String name;
    private String type;
    private MultipartFile data;
}
