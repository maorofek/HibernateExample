package entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Supply {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "supply_id")
    private Integer supplyId;
    @Basic
    @Column(name = "clinic_id")
    private Integer clinicId;
    @Basic
    @Column(name = "vaccine_id")
    private Integer vaccineId;
    @Basic
    @Column(name = "expiry_date")
    private Date expiryDate;
    @OneToMany(mappedBy = "supplyBySupplyId")
    private Collection<Dose> dosesBySupplyId;
    @ManyToOne
    @JoinColumn(name = "clinic_id", referencedColumnName = "clinic_id", nullable = false, insertable = false, updatable = false)
    private Clinic clinicByClinicId;
    @ManyToOne
    @JoinColumn(name = "vaccine_id", referencedColumnName = "vaccine_id", nullable = false, insertable = false, updatable = false)
    private Vaccine vaccineByVaccineId;

    public Integer getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(Integer supplyId) {
        this.supplyId = supplyId;
    }

    public Integer getClinicId() {
        return clinicId;
    }

    public void setClinicId(Integer clinicId) {
        this.clinicId = clinicId;
    }

    public Integer getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(Integer vaccineId) {
        this.vaccineId = vaccineId;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supply supply = (Supply) o;
        return Objects.equals(supplyId, supply.supplyId) && Objects.equals(clinicId, supply.clinicId) && Objects.equals(vaccineId, supply.vaccineId) && Objects.equals(expiryDate, supply.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplyId, clinicId, vaccineId, expiryDate);
    }

    public Collection<Dose> getDosesBySupplyId() {
        return dosesBySupplyId;
    }

    public void setDosesBySupplyId(Collection<Dose> dosesBySupplyId) {
        this.dosesBySupplyId = dosesBySupplyId;
    }

    public Clinic getClinicByClinicId() {
        return clinicByClinicId;
    }

    public void setClinicByClinicId(Clinic clinicByClinicId) {
        this.clinicByClinicId = clinicByClinicId;
    }

    public Vaccine getVaccineByVaccineId() {
        return vaccineByVaccineId;
    }

    public void setVaccineByVaccineId(Vaccine vaccineByVaccineId) {
        this.vaccineByVaccineId = vaccineByVaccineId;
    }
}
