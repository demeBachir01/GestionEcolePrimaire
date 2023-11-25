package backen.gestionbulletinprimaire.Entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@PrimaryKeyJoinColumn(name = "id")
public class Eleve extends  Personne {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Long id;
    private Long matricule;
    private Date dateNaissance;
    private String lieuDeNaissance;
    @ManyToMany
    private List<Classe> classe;
    @OneToMany(mappedBy = "eleve")
    private List<Composition> compositions;

}
