package backen.gestionbulletinprimaire.Repository;

import backen.gestionbulletinprimaire.Entites.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne,Long> {
}
