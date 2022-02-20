package entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class VaccinationPK implements Serializable {
    @Column(name = "worker_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer workerId;
    @Column(name = "citizen_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer citizenId;
    @Column(name = "phase")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer phase;

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
        VaccinationPK that = (VaccinationPK) o;
        return Objects.equals(workerId, that.workerId) && Objects.equals(citizenId, that.citizenId) && Objects.equals(phase, that.phase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workerId, citizenId, phase);
    }
}
