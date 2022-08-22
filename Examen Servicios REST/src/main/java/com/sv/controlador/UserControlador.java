package com.sv.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sv.modelos.User;
import com.sv.repositorio.InterfaceUsuario;

@RestController
@RequestMapping("/Cliente")
public class UserControlador { 
	
	@Autowired
	private InterfaceUsuario interfaceUser;
	
	@GetMapping
	public List<User> clientes() {
		return (List<User>) interfaceUser.findAll();
	}
	
	@GetMapping("/detalles/{Client_ID}") 
	public Optional<User> buscarPorId(@PathVariable("Client_ID") Integer Client_ID) {
		return interfaceUser.findById(Client_ID);
	}
	
	@PostMapping
	public void insertar (@RequestBody User us) {
		interfaceUser.save(us);
	}
	
	@PutMapping 
	public void modificar (@RequestBody User us) {
		interfaceUser.save(us);
	}

}
