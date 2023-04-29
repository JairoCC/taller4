package com.keycode.demo.service;

import com.keycode.demo.dto.ClienteRqDto;
import com.keycode.demo.dto.ClienteRsDto;

import java.util.List;

public interface IClienteService {

    public ClienteRsDto crearCliente(ClienteRqDto cliente);

    public List<ClienteRsDto> obtenerClientes();

    public ClienteRsDto obtenerClienteById(Long clienteId);

}
