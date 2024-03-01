package backen.gestionbulletinprimaire.Entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "directeur")
@PrimaryKeyJoinColumn(name = "id")
public class Directeur extends Personne {
    @OneToOne(mappedBy = "directeur")
    private Etablissement etablissement;

}
