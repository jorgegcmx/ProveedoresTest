package com.backSwagger.gapsi.Repository;

import com.backSwagger.gapsi.Entities.Proveedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProveedoresRepository extends JpaRepository<Proveedores,Long> {
    Proveedores findByNombre(String nombre);

}