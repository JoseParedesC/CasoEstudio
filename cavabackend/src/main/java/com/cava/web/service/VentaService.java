package com.cava.web.service;

import com.cava.web.domain.CarroCompra;
import com.cava.web.domain.CarroCompraItem;
import com.cava.web.domain.Vendedor;
import com.cava.web.domain.Venta;
import com.cava.web.dto.TableDTO;
import com.cava.web.dto.VentaDTO;
import com.cava.web.dto.VentaVendedorTableDTO;
import com.cava.web.mapper.VentaMapperImpl;
import com.cava.web.repository.CarroCompraItemRepository;
import com.cava.web.repository.CarroCompraRepository;
import com.cava.web.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService {
    //Repositorios
    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private CarroCompraRepository carroCompraRepository;
    //Mappers
    @Autowired
    private VentaMapperImpl ventaMapper;
    //Services
    @Autowired
    private CarroService carroService;

    public boolean saveCompra(VentaDTO ventaDTO){
        try{
            CarroCompra carroCompra = carroCompraRepository.findById(ventaDTO.getIdCarroCompra()).get();
            for(CarroCompraItem carroCompraItem : carroCompra.getCarroCompraItem()){
                Venta venta = ventaMapper.toVenta(ventaDTO);
                venta.setProducto(carroCompraItem.getProducto());
                venta.setVendedor(carroCompraItem.getProducto().getVendedor());
                venta.setCliente(carroCompra.getCliente());
                venta.setCantidad(carroCompraItem.getCantidad());
                venta.setTotal(carroCompraItem.getProducto().getPrecio() * venta.getCantidad());
                ventaRepository.save(venta);
                carroService.deleteProductById(venta.getProducto().getId(), ventaDTO.getIdCarroCompra());
            }
            carroCompra.setTotal(Double.parseDouble("0"));
            carroCompraRepository.save(carroCompra);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public TableDTO findAllByIdVendedor(Long id){
        TableDTO tableDTO = new TableDTO();
        try{
            Vendedor vendedor = new Vendedor();
            vendedor.setId(id);
            List<VentaVendedorTableDTO> ventas = new ArrayList<>();
            for (Venta venta : ventaRepository.findByVendedor(vendedor)){
                ventas.add(ventaMapper.toVentaVendedorTable(venta));
            }
            Page<?> page = new PageImpl<>(ventas);
            tableDTO = new TableDTO(page.getTotalPages(), page.getTotalElements(), page.getContent());
        }catch(Exception e){
            e.printStackTrace();
        }
        return tableDTO;
    }
}