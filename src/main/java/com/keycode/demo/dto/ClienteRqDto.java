package com.keycode.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class ClienteRqDto {

    @NotNull
    @NotEmpty
    @NotBlank
    @JsonProperty("nombre_cliente")
    private String nombre;

    @NotNull
    @NotEmpty
    @NotBlank
    @JsonProperty("apellido_cliente")
    private String apellido;

    @NotNull
    @JsonProperty("rol_cliente")
    private Long idRol;

}
