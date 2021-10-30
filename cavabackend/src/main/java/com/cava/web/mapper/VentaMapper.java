package com.cava.web.mapper;

import com.cava.web.domain.Venta;
import com.cava.web.dto.VentaDTO;
import com.cava.web.dto.VentaVendedorTableDTO;
import org.mapstruct.Mapper;

@Mapper
public interface VentaMapper {
    Venta toVenta(VentaDTO ventaDTO);
    VentaVendedorTableDTO toVentaVendedorTable(Venta venta);
}