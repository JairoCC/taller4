package com.keycode.demo.controller;

import com.keycode.demo.dto.ClienteRqDto;
import com.keycode.demo.dto.ClienteRsDto;
import com.keycode.demo.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @PostMapping(name = "/clientes", path = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ClienteRsDto crearCliente(@RequestBody @Valid ClienteRqDto cliente) {
        return clienteService.crearCliente(cliente);
    }

    @GetMapping(name = "/clientes", path = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClienteRsDto> obtenerClientes() {
        return clienteService.obtenerClientes();
    }

    @GetMapping(name = "/clientes/{cliente_id}", path = "/clientes/{cliente_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ClienteRsDto obtenerClienteById(@PathVariable("cliente_id") Long clienteId) {
        return clienteService.obtenerClienteById(clienteId);
    }

}
