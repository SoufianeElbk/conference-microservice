package ma.soufiane.conferenceservice.repository;


import ma.soufiane.conferenceservice.entity.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConferenceRepository extends JpaRepository<Conference,Long> {
}
