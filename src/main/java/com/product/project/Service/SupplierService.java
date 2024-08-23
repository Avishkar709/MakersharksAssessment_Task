package com.product.project.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.project.Entity.ManufacturingProcess;
import com.product.project.Entity.NatureOfBusiness;
import com.product.project.Entity.Supplier;
import com.product.project.Repository.SupplierRepository;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getSuppliers(String location, NatureOfBusiness natureOfBusiness, ManufacturingProcess manufacturingProcess) {
        return supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcessesContaining(location, natureOfBusiness, manufacturingProcess);
    }
}
