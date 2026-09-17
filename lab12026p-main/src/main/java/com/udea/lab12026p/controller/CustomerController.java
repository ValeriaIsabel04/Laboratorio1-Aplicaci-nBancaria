package com.udea.lab12026p.controller;

import com.udea.lab12026p.dto.CustomerDTO;
import com.udea.lab12026p.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerFacade;

    public CustomerController(CustomerService customerFacade) {
        this.customerFacade = customerFacade;
    }

    // 1. Obtener todos los clientes
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        return ResponseEntity.ok(customerFacade.getAllCustomers());
    }

    // 2. Obtener un cliente por su ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("id") long id) {
        return ResponseEntity.ok(customerFacade.getCustomerById(id));
    }

    // 3. Crear un nuevo cliente
    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        if (customerDTO.getBalance() == null) {
            throw new IllegalArgumentException("Balance cannot be null");
        }
        return ResponseEntity.ok(customerFacade.createCustomer(customerDTO));
    }

    // 4. Actualizar un cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable("id") long id, @RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerFacade.updateCustomer(id, customerDTO));
    }

    // 5. Eliminar un cliente por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") long id) {
        customerFacade.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}