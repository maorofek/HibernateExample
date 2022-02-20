import entities.Appointment;
import entities.Citizen;
import entities.Clinic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.Timestamp;
import java.util.List;

@SuppressWarnings("unchecked")
public class Main {

    public static void main(String[] args) {
        init();

        //example builder
        getAllClinics().forEach(System.out::println);
        Citizen c1 = Citizen.CitizenBuilder.aCitizen()
                .withAge(20)
                .withCitizenId(23351432)
                .withDistrict("asd")
                .withEmail("zasda@asasd.com")
                .build();

        close();
        
    }

    /**
     * Create an appointment and add it to the DB.
     *
     * @param citizen   a {@link Citizen} entity - the user.
     * @param clinic    a {@link Clinic} chosen by the user.
     * @param timestamp the appointment date chosen by the user.
     * @throws Exception if adding the appointment to the DB failed.
     */
    public static void createAppointment(Citizen citizen, Clinic clinic, Timestamp timestamp) throws Exception {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        Exception exp = null;

        try {
            transaction.begin();

            Appointment appointment = Appointment.AppointmentBuilder
                    .anAppointment()
                    .withCitizenId(citizen.getCitizenId())
                    .withClinicId(clinic.getClinicId())
                    .withDate(timestamp)
                    .build();

            em.persist(appointment);
            transaction.commit();
        } catch (Exception e) {
            // If there is an exception rollback changes
            if (transaction.isActive()) {
                transaction.rollback();
            }
            exp = e;
        } finally {
            em.close(); // Close EntityManager
        }
        if (exp != null) throw new Exception(exp.toString());
    }

    public static final String PERSISTENCE_UNIT_NAME = "Default";

    private static EntityManagerFactory entityManagerFactory;

    /**
     * Initialize the EntitiesManager.
     */
    public static void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    /**
     * Before exiting the program it's best practice closing any connection to the database.
     */
    public static void close() {
        if (entityManagerFactory != null) entityManagerFactory.close();
    }

    public static List<Clinic> getAllClinics() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Clinic> ret = em.createQuery("Select c from Clinic c").getResultList();
        em.close();
        return ret;
    }
}
