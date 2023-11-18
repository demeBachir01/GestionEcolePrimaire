package backen.gestionbulletinprimaire.Entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Licence {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long code;
    private Date dateDebut;
    private Date dateFin;
    @ManyToOne
    private Etablissement etablissement;
}
