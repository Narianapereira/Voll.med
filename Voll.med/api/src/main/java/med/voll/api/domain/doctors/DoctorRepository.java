package med.voll.api.domain.doctors;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Page<Doctor> findAllByActiveTrue(Pageable pagination);

    @Query("select m from doctor m where m.active = true and m.specialty = :specialty " +
            "and m.id not in(select c.doc.id from appointment c where c.date = :date" +
            ") order by rand() limit 1")
    Doctor chooseRandomDoctorBySpecialtyAndDate(Specialty specialty, LocalDateTime data);
}
