package com.backSwagger.gapsi.Controllers;

import com.backSwagger.gapsi.Request.RequestDelete;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class CandidatoController {

    private static final String MENSAJE_OBTENCION_DATOS = "Data Success";
    private static final String MENSAJE_DATOS_NO_ENCONTRADOS = "Data not found";

    @Operation(summary = "Lista Candidato")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = MENSAJE_OBTENCION_DATOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = RequestDelete.class)) } ),
            @ApiResponse(responseCode = "404" , description = MENSAJE_DATOS_NO_ENCONTRADOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = RequestDelete.class)) } )
    })
    @GetMapping(value = "/candidato", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> informacionCandidato(){
        HashMap<String,String> map = new HashMap<>();
        map.put("candidato","Jorge Antonio González Camacho");
        map.put("version","V1.1.0");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}