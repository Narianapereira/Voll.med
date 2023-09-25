package med.voll.api.domain.doctors;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Page<Doctor> findAllByActiveTrue(Pageable pagination);

    @Query("select m from doctor m\n" +
            "where\n" +
            "m.active = true\n" +
            "and\n" +
            "m.specialty = :specialty\n" +
            "and\n" +
            "m.id not in(\n" +
            "    select c.doc.id from appointment c\n" +
            "    where\n" +
            "    c.date = :date\n" +
            ")\n" +
            "order by rand()\n" +
            "limit 1\n")
    Doctor chooseRandomDoctorBySpecialtyAndDate(Specialty specialty, LocalDateTime date);
}
