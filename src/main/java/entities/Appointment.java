package entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Appointment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "appointment_id")
    private Integer appointmentId;
    @Basic
    @Column(name = "clinic_id")
    private Integer clinicId;
    @Basic
    @Column(name = "citizen_id")
    private Integer citizenId;
    @Basic
    @Column(name = "worker_id")
    private Integer workerId;
    @Basic
    @Column(name = "date")
    private Timestamp date;
    @ManyToOne
    @JoinColumn(name = "clinic_id", referencedColumnName = "clinic_id", nullable = false, insertable = false, updatable = false)
    private Clinic clinicByClinicId;
    @ManyToOne
    @JoinColumn(name = "citizen_id", referencedColumnName = "citizen_id", nullable = false, insertable = false, updatable = false)
    private Citizen citizenByCitizenId;
    @ManyToOne
    @JoinColumn(name = "worker_id", referencedColumnName = "worker_id", nullable = false, insertable = false, updatable = false)
    private Worker workerByWorkerId;

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Integer getClinicId() {
        return clinicId;
    }

    public void setClinicId(Integer clinicId) {
        this.clinicId = clinicId;
    }

    public Integer getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Integer citizenId) {
        this.citizenId = citizenId;
    }

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(appointmentId, that.appointmentId) && Objects.equals(clinicId, that.clinicId) && Objects.equals(citizenId, that.citizenId) && Objects.equals(workerId, that.workerId) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentId, clinicId, citizenId, workerId, date);
    }

    public Clinic getClinicByClinicId() {
        return clinicByClinicId;
    }

    public void setClinicByClinicId(Clinic clinicByClinicId) {
        this.clinicByClinicId = clinicByClinicId;
    }

    public Citizen getCitizenByCitizenId() {
        return citizenByCitizenId;
    }

    public void setCitizenByCitizenId(Citizen citizenByCitizenId) {
        this.citizenByCitizenId = citizenByCitizenId;
    }

    public Worker getWorkerByWorkerId() {
        return workerByWorkerId;
    }

    public void setWorkerByWorkerId(Worker workerByWorkerId) {
        this.workerByWorkerId = workerByWorkerId;
    }

    public static final class AppointmentBuilder {
        private Integer appointmentId;
        private Integer clinicId;
        private Integer citizenId;
        private Integer workerId;
        private Timestamp date;

        private AppointmentBuilder() {
        }

        public static AppointmentBuilder anAppointment() {
            return new AppointmentBuilder();
        }

        public AppointmentBuilder withAppointmentId(Integer appointmentId) {
            this.appointmentId = appointmentId;
            return this;
        }

        public AppointmentBuilder withClinicId(Integer clinicId) {
            this.clinicId = clinicId;
            return this;
        }

        public AppointmentBuilder withCitizenId(Integer citizenId) {
            this.citizenId = citizenId;
            return this;
        }

        public AppointmentBuilder withWorkerId(Integer workerId) {
            this.workerId = workerId;
            return this;
        }

        public AppointmentBuilder withDate(Timestamp date) {
            this.date = date;
            return this;
        }

        public Appointment build() {
            Appointment appointment = new Appointment();
            appointment.setAppointmentId(appointmentId);
            appointment.setClinicId(clinicId);
            appointment.setCitizenId(citizenId);
            appointment.setWorkerId(workerId);
            appointment.setDate(date);
            return appointment;
        }
    }
}
