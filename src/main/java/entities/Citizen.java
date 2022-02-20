package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Citizen {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "citizen_id")
    private Integer citizenId;
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
    @Column(name = "age")
    private Integer age;
    @Basic
    @Column(name = "weight")
    private Integer weight;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "district")
    private String district;
    @Basic
    @Column(name = "phases_complete")
    private Integer phasesComplete;
    @Basic
    @Column(name = "risk_group")
    private RiskGroup riskGroup;
    @OneToMany(mappedBy = "citizenByCitizenId")
    private Collection<Appointment> appointmentsByCitizenId;
    @OneToMany(mappedBy = "citizenByCitizenId")
    private Collection<Vaccination> vaccinationsByCitizenId;

    public enum RiskGroup {
        Max,
        High,
        Regular
    }

    public Integer getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Integer citizenId) {
        this.citizenId = citizenId;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getPhasesComplete() {
        return phasesComplete;
    }

    public void setPhasesComplete(Integer phasesComplete) {
        this.phasesComplete = phasesComplete;
    }

    public RiskGroup getRiskGroup() {
        return riskGroup;
    }

    public void setRiskGroup(RiskGroup riskGroup) {
        this.riskGroup = riskGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Citizen citizen = (Citizen) o;
        return Objects.equals(citizenId, citizen.citizenId) && Objects.equals(firstName, citizen.firstName) && Objects.equals(lastName, citizen.lastName) && Objects.equals(phoneNum, citizen.phoneNum) && Objects.equals(age, citizen.age) && Objects.equals(weight, citizen.weight) && Objects.equals(email, citizen.email) && Objects.equals(district, citizen.district) && Objects.equals(phasesComplete, citizen.phasesComplete) && Objects.equals(riskGroup, citizen.riskGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(citizenId, firstName, lastName, phoneNum, age, weight, email, district, phasesComplete, riskGroup);
    }

    public Collection<Appointment> getAppointmentsByCitizenId() {
        return appointmentsByCitizenId;
    }

    public void setAppointmentsByCitizenId(Collection<Appointment> appointmentsByCitizenId) {
        this.appointmentsByCitizenId = appointmentsByCitizenId;
    }

    public Collection<Vaccination> getVaccinationsByCitizenId() {
        return vaccinationsByCitizenId;
    }

    public void setVaccinationsByCitizenId(Collection<Vaccination> vaccinationsByCitizenId) {
        this.vaccinationsByCitizenId = vaccinationsByCitizenId;
    }

    public static final class CitizenBuilder {
        private Integer citizenId;
        private String firstName;
        private String lastName;
        private String phoneNum;
        private Integer age;
        private Integer weight;
        private String email;
        private String district;
        private Integer phasesComplete;
        private RiskGroup riskGroup;

        private CitizenBuilder() {
        }

        public static CitizenBuilder aCitizen() {
            return new CitizenBuilder();
        }

        public CitizenBuilder withCitizenId(Integer citizenId) {
            this.citizenId = citizenId;
            return this;
        }

        public CitizenBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public CitizenBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public CitizenBuilder withPhoneNum(String phoneNum) {
            this.phoneNum = phoneNum;
            return this;
        }

        public CitizenBuilder withAge(Integer age) {
            this.age = age;
            return this;
        }

        public CitizenBuilder withWeight(Integer weight) {
            this.weight = weight;
            return this;
        }

        public CitizenBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public CitizenBuilder withDistrict(String district) {
            this.district = district;
            return this;
        }

        public CitizenBuilder withPhasesComplete(Integer phasesComplete) {
            this.phasesComplete = phasesComplete;
            return this;
        }

        public CitizenBuilder withRiskGroup(RiskGroup riskGroup) {
            this.riskGroup = riskGroup;
            return this;
        }

        public Citizen build() {
            Citizen citizen = new Citizen();
            citizen.setCitizenId(citizenId);
            citizen.setFirstName(firstName);
            citizen.setLastName(lastName);
            citizen.setPhoneNum(phoneNum);
            citizen.setAge(age);
            citizen.setWeight(weight);
            citizen.setEmail(email);
            citizen.setDistrict(district);
            citizen.setPhasesComplete(phasesComplete);
            citizen.setRiskGroup(riskGroup);
            return citizen;
        }
    }
}
