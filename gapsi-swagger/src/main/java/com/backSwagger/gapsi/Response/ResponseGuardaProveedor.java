package com.backSwagger.gapsi.Response;

import com.backSwagger.gapsi.Entities.Proveedores;
import lombok.Data;

@Data
public class ResponseGuardaProveedor {
    private String mensaje;
    private Proveedores proveedores;
}
