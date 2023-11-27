package backen.gestionbulletinprimaire.Repository;

import backen.gestionbulletinprimaire.Entites.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtablissementRepository extends JpaRepository<Etablissement,Long> {
}
