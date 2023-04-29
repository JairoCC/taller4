package com.keycode.demo.util;

import com.keycode.demo.dto.ClienteRsDto;
import com.keycode.demo.model.Cliente;

public class ModelToDTO {

    public static ClienteRsDto toClienteRsDto(Cliente cliente){
        ClienteRsDto clienteRsDto = new ClienteRsDto();
        clienteRsDto.setId(cliente.getId());
        clienteRsDto.setNombre(cliente.getNombre());
        clienteRsDto.setApellido(cliente.getApellido());
        clienteRsDto.setNombreRol(cliente.getRol().getNombre());

        return clienteRsDto;
    }

}
