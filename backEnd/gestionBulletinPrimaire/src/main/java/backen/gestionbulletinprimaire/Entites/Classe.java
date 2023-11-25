package backen.gestionbulletinprimaire.Entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nomClasse;
    @ManyToMany(mappedBy = "classes")
    private List<Maitre> maitres;
    @ManyToOne
    private Niveau niveaux;
    @ManyToMany(mappedBy = "classe")
    private List<Eleve> eleves;
}
