package com.backSwagger.gapsi.ImpServicios;

import com.backSwagger.gapsi.Entities.Proveedores;
import com.backSwagger.gapsi.Interfaz.ProveedoresService;
import com.backSwagger.gapsi.Repository.ProveedoresRepository;
import com.backSwagger.gapsi.Request.RequestProveedor;
import com.backSwagger.gapsi.Response.ResponseGuardaProveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProveedoresIpm implements ProveedoresService {

    @Autowired
    ProveedoresRepository repository;


    @Override
    public ResponseGuardaProveedor Guarda(RequestProveedor proveedor) {
        ResponseGuardaProveedor response = new ResponseGuardaProveedor();
        Proveedores validaExistencia = valida(proveedor);
        Proveedores proveedores = new Proveedores();
        if (validaExistencia != null) {
            if (proveedor.getNombre().equalsIgnoreCase(validaExistencia.getNombre())) {
                response.setProveedores(validaExistencia);
                response.setMensaje("Erro! ya existe un Proveedor con el mismo nombre");
            } else {
                proveedores.setNombre(proveedor.getNombre());
                proveedores.setRazonsocial(proveedor.getRazonsocial());
                proveedores.setDireccion(proveedor.getDireccion());
                repository.save(proveedores);
                response.setProveedores(proveedores);
                response.setMensaje("Se creo el registro de forma correcta");
            }

        }else{
            proveedores.setNombre(proveedor.getNombre());
            proveedores.setRazonsocial(proveedor.getRazonsocial());
            proveedores.setDireccion(proveedor.getDireccion());
            repository.save(proveedores);
            response.setProveedores(proveedores);
            response.setMensaje("Se creo el registro de forma correcta");
        }

        return response;
    }

    @Override
    public List<Proveedores> Lista() {
        return (List<Proveedores>) repository.findAll();
    }

    @Override
    public void Elimina(Long id) {
         repository.deleteById(id);
    }

    @Override
    public Proveedores valida(RequestProveedor proveedor) {
        return repository.findByNombre(proveedor.getNombre());
    }

    @Override
    public Page<Proveedores> ListaPaginas(Integer page, Integer size) {
      final  Pageable pageable = PageRequest.of(page,size);
        return repository.findAll(pageable);
    }


}