package com.keycode.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ClienteRsDto {

    @JsonProperty("id_cliente")
    private Long id;

    @JsonProperty("nombre_cliente")
    private String nombre;

    @JsonProperty("apellido_cliente")
    private String apellido;

    @JsonProperty("nombre_rol")
    private String nombreRol;

}
