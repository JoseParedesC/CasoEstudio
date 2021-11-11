package com.cava.web.mapper;

import com.cava.web.domain.Venta;
import com.cava.web.dto.VentaDTO;
import com.cava.web.dto.VentaVendedorTableDTO;
import com.cava.web.utilities.Constantes;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class VentaMapperImpl implements VentaMapper{

    @Override
    public Venta toVenta(VentaDTO ventaDTO) {
        if(ventaDTO == null)
            return null;
        Venta venta = new Venta();
        venta.setId(0L);
        venta.setTelefonoContacto(ventaDTO.getTelefonoContacto());
        venta.setMetodoPago(ventaDTO.getMetodoPago());
        venta.setNumeroTarjeta(ventaDTO.getNumeroTarjeta());
        venta.setNombrePropietario(ventaDTO.getNombrePropietario());
        venta.setFechaExpiracion(ventaDTO.getFechaExpiracion());
        venta.setDireccion(ventaDTO.getDireccion());
        venta.setCvv(Integer.parseInt(ventaDTO.getCvv()));
        venta.setEstado(Constantes.PROCESO.getValue());
        venta.setCreated(new Date());
        return venta;
    }

    @Override
    public VentaVendedorTableDTO toVentaVendedorTable(Venta venta) {
        if(venta == null)
            return null;
        VentaVendedorTableDTO vendedorTableDTO = new VentaVendedorTableDTO();
        vendedorTableDTO.setId(venta.getId());
        vendedorTableDTO.setCliente(venta.getCliente().getNombre());
        vendedorTableDTO.setProducto(venta.getProducto().getNombre());
        vendedorTableDTO.setCantidad(venta.getCantidad());
        vendedorTableDTO.setTotal(venta.getTotal());
        return vendedorTableDTO;
    }
}