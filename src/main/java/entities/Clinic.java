package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Clinic {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "clinic_id")
    private Integer clinicId;
    @Basic
    @Column(name = "clinic_name")
    private String clinicName;
    @Basic
    @Column(name = "phone_num")
    private String phoneNum;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "street")
    private String street;
    @Basic
    @Column(name = "house_num")
    private Integer houseNum;
    @Basic
    @Column(name = "district")
    private String district;
    @OneToMany(mappedBy = "clinicByClinicId")
    private Collection<Appointment> appointmentsByClinicId;
    @OneToMany(mappedBy = "clinicByClinicId")
    private Collection<Supply> suppliesByClinicId;
    @OneToMany(mappedBy = "clinicByClinicId")
    private Collection<Worker> workersByClinicId;

    public Integer getClinicId() {
        return clinicId;
    }

    public void setClinicId(Integer clinicId) {
        this.clinicId = clinicId;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(Integer houseNum) {
        this.houseNum = houseNum;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clinic clinic = (Clinic) o;
        return Objects.equals(clinicId, clinic.clinicId) && Objects.equals(clinicName, clinic.clinicName) && Objects.equals(phoneNum, clinic.phoneNum) && Objects.equals(email, clinic.email) && Objects.equals(street, clinic.street) && Objects.equals(houseNum, clinic.houseNum) && Objects.equals(district, clinic.district);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clinicId, clinicName, phoneNum, email, street, houseNum, district);
    }

    public Collection<Appointment> getAppointmentsByClinicId() {
        return appointmentsByClinicId;
    }

    public void setAppointmentsByClinicId(Collection<Appointment> appointmentsByClinicId) {
        this.appointmentsByClinicId = appointmentsByClinicId;
    }

    public Collection<Supply> getSuppliesByClinicId() {
        return suppliesByClinicId;
    }

    public void setSuppliesByClinicId(Collection<Supply> suppliesByClinicId) {
        this.suppliesByClinicId = suppliesByClinicId;
    }

    public Collection<Worker> getWorkersByClinicId() {
        return workersByClinicId;
    }

    public void setWorkersByClinicId(Collection<Worker> workersByClinicId) {
        this.workersByClinicId = workersByClinicId;
    }

    @Override
    public String toString() {
        return "Clinic{" +
                "clinicId=" + clinicId +
                ", clinicName='" + clinicName + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", email='" + email + '\'' +
                ", street='" + street + '\'' +
                ", houseNum=" + houseNum +
                ", district='" + district + '\'' +
                '}';
    }
}
