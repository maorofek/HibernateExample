package entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@IdClass(VaccinationPK.class)
public class Vaccination {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "worker_id")
    private Integer workerId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "citizen_id")
    private Integer citizenId;
    @Basic
    @Column(name = "dose_barcode")
    private Integer doseBarcode;
    @Basic
    @Column(name = "date")
    private Timestamp date;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "phase")
    private Integer phase;
    @ManyToOne
    @JoinColumn(name = "worker_id", referencedColumnName = "worker_id", nullable = false, insertable = false, updatable = false)
    private Worker workerByWorkerId;
    @ManyToOne
    @JoinColumn(name = "citizen_id", referencedColumnName = "citizen_id", nullable = false, insertable = false, updatable = false)
    private Citizen citizenByCitizenId;
    @ManyToOne
    @JoinColumn(name = "dose_barcode", referencedColumnName = "barcode", nullable = false, insertable = false, updatable = false)
    private Dose doseByDoseBarcode;

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    public Integer getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Integer citizenId) {
        this.citizenId = citizenId;
    }

    public Integer getDoseBarcode() {
        return doseBarcode;
    }

    public void setDoseBarcode(Integer doseBarcode) {
        this.doseBarcode = doseBarcode;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Integer getPhase() {
        return phase;
    }

    public void setPhase(Integer phase) {
        this.phase = phase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vaccination that = (Vaccination) o;
        return Objects.equals(workerId, that.workerId) && Objects.equals(citizenId, that.citizenId) && Objects.equals(doseBarcode, that.doseBarcode) && Objects.equals(date, that.date) && Objects.equals(phase, that.phase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workerId, citizenId, doseBarcode, date, phase);
    }

    public Worker getWorkerByWorkerId() {
        return workerByWorkerId;
    }

    public void setWorkerByWorkerId(Worker workerByWorkerId) {
        this.workerByWorkerId = workerByWorkerId;
    }

    public Citizen getCitizenByCitizenId() {
        return citizenByCitizenId;
    }

    public void setCitizenByCitizenId(Citizen citizenByCitizenId) {
        this.citizenByCitizenId = citizenByCitizenId;
    }

    public Dose getDoseByDoseBarcode() {
        return doseByDoseBarcode;
    }

    public void setDoseByDoseBarcode(Dose doseByDoseBarcode) {
        this.doseByDoseBarcode = doseByDoseBarcode;
    }
}
