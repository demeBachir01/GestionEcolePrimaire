package backen.gestionbulletinprimaire.Entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomSemestre;
    @OneToMany
    private Collection<Composition>composition;
    @ManyToOne
    private Annee annee;
}
