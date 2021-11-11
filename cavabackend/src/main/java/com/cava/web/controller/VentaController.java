package com.cava.web.controller;

import com.cava.web.dto.VentaDTO;
import com.cava.web.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ventas")
@CrossOrigin("*")
public class VentaController {
    @Autowired
    private VentaService ventaService;
    //POST
    @PostMapping
    public ResponseEntity<?> saveCompra(@RequestBody VentaDTO ventaDTO){
        return new ResponseEntity<>(ventaService.saveCompra(ventaDTO) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    //GET
    @GetMapping("/vendedor/{id}")
    public ResponseEntity<?> getAllByVendedor(@PathVariable Long id){
        return new ResponseEntity<>(ventaService.findAllByIdVendedor(id), HttpStatus.OK);
    }
}