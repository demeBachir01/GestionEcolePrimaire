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
@Table(name = "classe")
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String nomClasse;
    @ManyToMany(mappedBy = "classes")
    private List<Maitre> maitres;
    @ManyToOne
    private Niveau niveaux;
    @ManyToMany(mappedBy = "classe")
    private List<Eleve> eleves;
}
