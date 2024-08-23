package com.product.project.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.product.project.Entity.ManufacturingProcess;
import com.product.project.Entity.NatureOfBusiness;
import com.product.project.Entity.Supplier;
import com.product.project.Service.SupplierService;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/query")
    public List<Supplier> querySuppliers(
            @RequestParam String location,
            @RequestParam NatureOfBusiness natureOfBusiness,
            @RequestParam ManufacturingProcess manufacturingProcess,
            @RequestParam(required = false, defaultValue = "10") int limit
    ) {
    	List<Supplier> suppliers = supplierService.getSuppliers("India", NatureOfBusiness.SMALL_SCALE, ManufacturingProcess.THREE_D_PRINTING);
        return suppliers.subList(0, Math.min(limit, suppliers.size()));
    }
}
