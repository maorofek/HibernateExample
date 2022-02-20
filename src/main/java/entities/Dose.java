package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Dose {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "barcode")
    private Integer barcode;
    @Basic
    @Column(name = "supply_id")
    private Integer supplyId;
    @ManyToOne
    @JoinColumn(name = "supply_id", referencedColumnName = "supply_id", nullable = false, insertable = false, updatable = false)
    private Supply supplyBySupplyId;
    @OneToMany(mappedBy = "doseByDoseBarcode")
    private Collection<Vaccination> vaccinationsByBarcode;

    public Integer getBarcode() {
        return barcode;
    }

    public void setBarcode(Integer barcode) {
        this.barcode = barcode;
    }

    public Integer getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(Integer supplyId) {
        this.supplyId = supplyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dose dose = (Dose) o;
        return Objects.equals(barcode, dose.barcode) && Objects.equals(supplyId, dose.supplyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barcode, supplyId);
    }

    public Supply getSupplyBySupplyId() {
        return supplyBySupplyId;
    }

    public void setSupplyBySupplyId(Supply supplyBySupplyId) {
        this.supplyBySupplyId = supplyBySupplyId;
    }

    public Collection<Vaccination> getVaccinationsByBarcode() {
        return vaccinationsByBarcode;
    }

    public void setVaccinationsByBarcode(Collection<Vaccination> vaccinationsByBarcode) {
        this.vaccinationsByBarcode = vaccinationsByBarcode;
    }
}
