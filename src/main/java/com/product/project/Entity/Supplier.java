package com.product.project.Entity;

import jakarta.persistence.*;
import java.util.Set;
import com.product.project.Entity.NatureOfBusiness;
import com.product.project.Entity.ManufacturingProcess;

@Entity
public class Supplier {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierId;

    private String companyName;
    private String website;
    private String location;

    @Enumerated(EnumType.STRING)
    private NatureOfBusiness natureOfBusiness;

    @ElementCollection(targetClass = ManufacturingProcess.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "supplier_manufacturing_processes")
    @Column(name = "manufacturing_process")
    private Set<ManufacturingProcess> manufacturingProcesses;

    // Getters and Setters

    public enum NatureOfBusiness {
        SMALL_SCALE,
        MEDIUM_SCALE,
        LARGE_SCALE
    }

    public enum ManufacturingProcess {
        MOULDING,
        _3D_PRINTING,
        CASTING,
        COATING
    }
}
