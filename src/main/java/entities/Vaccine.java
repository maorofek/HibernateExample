package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Vaccine {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "vaccine_id")
    private Integer vaccineId;
    @Basic
    @Column(name = "vaccine_name")
    private String vaccineName;
    @Basic
    @Column(name = "company")
    private String company;
    @OneToMany(mappedBy = "vaccineByVaccineId")
    private Collection<Supply> suppliesByVaccineId;

    public Integer getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(Integer vaccineId) {
        this.vaccineId = vaccineId;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vaccine vaccine = (Vaccine) o;
        return Objects.equals(vaccineId, vaccine.vaccineId) && Objects.equals(vaccineName, vaccine.vaccineName) && Objects.equals(company, vaccine.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vaccineId, vaccineName, company);
    }

    public Collection<Supply> getSuppliesByVaccineId() {
        return suppliesByVaccineId;
    }

    public void setSuppliesByVaccineId(Collection<Supply> suppliesByVaccineId) {
        this.suppliesByVaccineId = suppliesByVaccineId;
    }
}
