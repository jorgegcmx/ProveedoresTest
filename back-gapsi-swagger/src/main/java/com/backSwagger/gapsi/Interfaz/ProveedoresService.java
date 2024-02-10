package com.backSwagger.gapsi.Interfaz;

import com.backSwagger.gapsi.Entities.Proveedores;
import com.backSwagger.gapsi.Request.RequestProveedor;
import com.backSwagger.gapsi.Response.ResponseGuardaProveedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface ProveedoresService {
    ResponseGuardaProveedor Guarda(RequestProveedor proveedor);
    List<Proveedores> Lista();
    void Elimina (Long id);
    Proveedores valida(RequestProveedor proveedor);
    Page<Proveedores> ListaPaginas(Integer  page, Integer size);

}