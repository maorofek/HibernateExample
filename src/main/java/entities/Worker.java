package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Worker {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "worker_id")
    private Integer workerId;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "phone_num")
    private String phoneNum;
    @Basic
    @Column(name = "medical_license")
    private Integer medicalLicense;
    @Basic
    @Column(name = "seniority")
    private Integer seniority;
    @Basic
    @Column(name = "clinic_id")
    private Integer clinicId;
    @OneToMany(mappedBy = "workerByWorkerId")
    private Collection<Appointment> appointmentsByWorkerId;
    @OneToMany(mappedBy = "workerByWorkerId")
    private Collection<Vaccination> vaccinationsByWorkerId;
    @ManyToOne
    @JoinColumn(name = "clinic_id", referencedColumnName = "clinic_id", nullable = false, insertable = false, updatable = false)
    private Clinic clinicByClinicId;

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getMedicalLicense() {
        return medicalLicense;
    }

    public void setMedicalLicense(Integer medicalLicense) {
        this.medicalLicense = medicalLicense;
    }

    public Integer getSeniority() {
        return seniority;
    }

    public void setSeniority(Integer seniority) {
        this.seniority = seniority;
    }

    public Integer getClinicId() {
        return clinicId;
    }

    public void setClinicId(Integer clinicId) {
        this.clinicId = clinicId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Objects.equals(workerId, worker.workerId) && Objects.equals(firstName, worker.firstName) && Objects.equals(lastName, worker.lastName) && Objects.equals(phoneNum, worker.phoneNum) && Objects.equals(medicalLicense, worker.medicalLicense) && Objects.equals(seniority, worker.seniority) && Objects.equals(clinicId, worker.clinicId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workerId, firstName, lastName, phoneNum, medicalLicense, seniority, clinicId);
    }

    public Collection<Appointment> getAppointmentsByWorkerId() {
        return appointmentsByWorkerId;
    }

    public void setAppointmentsByWorkerId(Collection<Appointment> appointmentsByWorkerId) {
        this.appointmentsByWorkerId = appointmentsByWorkerId;
    }

    public Collection<Vaccination> getVaccinationsByWorkerId() {
        return vaccinationsByWorkerId;
    }

    public void setVaccinationsByWorkerId(Collection<Vaccination> vaccinationsByWorkerId) {
        this.vaccinationsByWorkerId = vaccinationsByWorkerId;
    }

    public Clinic getClinicByClinicId() {
        return clinicByClinicId;
    }

    public void setClinicByClinicId(Clinic clinicByClinicId) {
        this.clinicByClinicId = clinicByClinicId;
    }
}
