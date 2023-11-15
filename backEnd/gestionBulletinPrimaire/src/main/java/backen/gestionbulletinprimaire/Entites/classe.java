package backen.gestionbulletinprimaire.Entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomClasse;
    private  int niveau;
    @OneToOne
    private Maitre maitre;
    @ManyToOne
    private Niveau niveaus;
    @OneToMany
    private Collection<Eleve> eleves;
}
