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
@Table(name = "licence")
public class Licence {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private Long code;
    @Column(nullable = false)
    private Date dateDebut;
    @Column(nullable = false)
    private Date dateFin;
    @ManyToOne
    private Etablissement etablissement;
}
