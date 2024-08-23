package com.product.project.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.project.Entity.ManufacturingProcess;
import com.product.project.Entity.NatureOfBusiness;
import com.product.project.Entity.Supplier;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    List<Supplier> findByLocationAndNatureOfBusinessAndManufacturingProcessesContaining(
            String location, 
            NatureOfBusiness natureOfBusiness, 
            ManufacturingProcess manufacturingProcess
    );
}
