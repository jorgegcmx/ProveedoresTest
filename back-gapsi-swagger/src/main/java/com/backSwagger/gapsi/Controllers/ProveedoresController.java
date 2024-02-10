package com.backSwagger.gapsi.Controllers;

import com.backSwagger.gapsi.Entities.Proveedores;
import com.backSwagger.gapsi.Interfaz.ProveedoresService;
import com.backSwagger.gapsi.Request.RequestDelete;
import com.backSwagger.gapsi.Request.RequestProveedor;
import com.backSwagger.gapsi.Response.ResponseGuardaProveedor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProveedoresController {

    @Autowired
    ProveedoresService service;
    private static final String MENSAJE_OBTENCION_DATOS = "Data Success";
    private static final String MENSAJE_DATOS_NO_ENCONTRADOS = "Data not found";

    @Operation(summary = "Guarda Proveedores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = MENSAJE_OBTENCION_DATOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = RequestProveedor.class)) } ),
            @ApiResponse(responseCode = "404" , description = MENSAJE_DATOS_NO_ENCONTRADOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = RequestProveedor.class)) } )
    })
    @PostMapping(value = "/guarda_proveedores", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseGuardaProveedor> save(@RequestBody RequestProveedor proveedor){
        return new ResponseEntity<ResponseGuardaProveedor>(service.Guarda(proveedor), HttpStatus.OK);
    }

    @Operation(summary = "Lista registro Proveedores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = MENSAJE_OBTENCION_DATOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Proveedores.class)) } ),
            @ApiResponse(responseCode = "404" , description = MENSAJE_DATOS_NO_ENCONTRADOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Proveedores.class)) } )
    })
    @GetMapping(value = "/lista_proveedores", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Proveedores>> list(){
        return new ResponseEntity<List<Proveedores>>(service.Lista(), HttpStatus.OK);
    }

    @Operation(summary = "Lista registro paginados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = MENSAJE_OBTENCION_DATOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Proveedores.class)) } ),
            @ApiResponse(responseCode = "404" , description = MENSAJE_DATOS_NO_ENCONTRADOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Proveedores.class)) } )
    })
    @GetMapping(value = "/lista_proveedores_paginados")
    public ResponseEntity<Page<Proveedores>> listPaginados(@RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size){
        return new ResponseEntity<Page<Proveedores>>(service.ListaPaginas(page,size), HttpStatus.OK);
    }

    @Operation(summary = "Elimina Proveedores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = MENSAJE_OBTENCION_DATOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Proveedores.class)) } ),
            @ApiResponse(responseCode = "404" , description = MENSAJE_DATOS_NO_ENCONTRADOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Proveedores.class)) } )
    })
    @PostMapping(value = "/elimina_proveedores", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> elimina(@RequestBody RequestDelete request){
        String msg = "ok";
        try {
            service.Elimina(request.getId());
        }catch (Exception e){
            msg = e.toString();
        }
        return new ResponseEntity<String>(msg, HttpStatus.OK);
    }
}
