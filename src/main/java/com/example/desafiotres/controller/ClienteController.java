package com.example.desafiotres.controller;

import com.example.desafiotres.repository.ClienteRepository;
import com.example.desafiotres.model.Cliente;
import com.example.desafiotres.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteRepository repo;

    // GET -------------------------------------------------------------------------
    @GetMapping("/listar")
    public List<Cliente> getClientesAll () {
        try {
            return repo.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/{id}")
    public Cliente getCliente (@PathVariable Long id) {
        Cliente getCliente = repo.findById(id).orElse(null);
        try {
            if (getCliente!=null) {
                int edad = ClienteService.calcularEdad(getCliente.getFechaNacimiento());
                getCliente.setEdad(edad);
                return getCliente;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    // POST ------------------------------------------------------------------------
    @PostMapping("/cargar")
    public String postCliente (@RequestBody Cliente cliente) {
        try {
            int edad = ClienteService.calcularEdad(cliente.getFechaNacimiento());
            cliente.setEdad(edad);
            repo.save(cliente);
            return "Nuevo cliente cargado";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al cargar el cliente";
        }
    }

    // PUT -------------------------------------------------------------------------
    @PutMapping("/actualizar/{id}")
    public String updateCliente (@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente updateCliente = repo.findById(id).orElse(null);
        try {
            if (updateCliente!=null) {
                updateCliente.setNombre(cliente.getNombre());
                updateCliente.setApellido(cliente.getApellido());
                updateCliente.setFechaNacimiento(cliente.getFechaNacimiento());
                updateCliente.setEdad(cliente.getEdad());
                repo.save(updateCliente);
                return "Cliente actualizado";
            } else {
                return "Cliente no encontrado";
            }
        } catch (Exception e) {
            return "Cliente no encontrado";
        }
    }

    // DELETE ----------------------------------------------------------------------
    @DeleteMapping("/eliminar/{id}")
    public String deleteCliente (@PathVariable Long id) {
        Cliente deleteCliente = repo.findById(id).orElse(null);
        if (deleteCliente!=null) {
            repo.delete(deleteCliente);
            return "Cliente eliminado";
        } else {
            return "Cliente no encontrado";
        }
    }
}