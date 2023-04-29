package com.keycode.demo.service.impl;

import com.keycode.demo.dto.ClienteRqDto;
import com.keycode.demo.dto.ClienteRsDto;
import com.keycode.demo.model.Cliente;
import com.keycode.demo.repository.ClienteRepository;
import com.keycode.demo.repository.RolRepository;
import com.keycode.demo.service.IClienteService;
import com.keycode.demo.util.ModelToDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.keycode.demo.util.enums.RolEnum.ADMIN;
import static com.keycode.demo.util.enums.RolEnum.USER;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ClienteRsDto crearCliente(ClienteRqDto cliente) {
        Cliente cliente1 = new Cliente();
        cliente1.setNombre(cliente.getNombre());
        cliente1.setApellido(cliente.getApellido());

        if(cliente.getIdRol().equals(ADMIN.getIdRol())){
            cliente1.setRol(rolRepository.findById(ADMIN.getIdRol()).get());
        }else if(cliente.getIdRol().equals(USER.getIdRol())){
            cliente1.setRol(rolRepository.findById(USER.getIdRol()).get());
        }else{
            throw new RuntimeException("EL ROL SUMINISTRADO NO EXISTE");
        }

        cliente1 = clienteRepository.save(cliente1);

        return modelMapper.map(cliente1 ,ClienteRsDto.class);
    }

    @Override
    public List<ClienteRsDto> obtenerClientes() {

        return clienteRepository.findAll()
                .stream()
                .map(cliente -> modelMapper.map(cliente ,ClienteRsDto.class)
                )
                .collect(Collectors.toList());
    }

    @Override
    public ClienteRsDto obtenerClienteById(Long clienteId) {
        Cliente cliente = clienteRepository
                .findById(clienteId)
                .get();

        return ModelToDTO.toClienteRsDto(cliente);
    }

    public ClienteRsDto obtenerClienteByNombre(String nombre){
        return  null;
        /*Cliente cliente = clienteRepository
                .findByUsername(nombre)
                .get();
        return ModelToDTO.toClienteRsDto(cliente);*/
    }
}
