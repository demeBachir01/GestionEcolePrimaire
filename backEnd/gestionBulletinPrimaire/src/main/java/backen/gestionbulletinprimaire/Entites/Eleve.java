package backen.gestionbulletinprimaire.Entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Eleve {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private Long matricule;
    private Date dateNaissance;
    private String lieuDeNaissance;
    @ManyToMany
    private List<classe> classe;
    @OneToMany(mappedBy = "eleve")
    private List<Composition> compositions;

}
