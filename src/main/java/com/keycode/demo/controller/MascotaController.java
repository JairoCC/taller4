package com.keycode.demo.controller;

import com.keycode.demo.model.Cliente;
import com.keycode.demo.repository.ClienteRepository;
import com.keycode.demo.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MascotaController {

    @Autowired
    private IClienteService clienteService;
    private final ClienteRepository cliente;

    public MascotaController(ClienteRepository cliente) {
        this.cliente = cliente;
    }

    @GetMapping("/clientes")
    public String index(Model model) {
        model.addAttribute("clientes", clienteService.obtenerClientes());
        return "index";
    }
    @GetMapping("/clientes/{cliente_id}")
    public String index2(Model model, @PathVariable("cliente_id") Long clienteId) {
        model.addAttribute("clientes", clienteService.obtenerClienteById(clienteId));
        return "index2";
    }
/*    @GetMapping("/{id}")
    public Cliente findById(@PathVariable("id") Cliente cliente1){
        return cliente1;

    }*/

}
