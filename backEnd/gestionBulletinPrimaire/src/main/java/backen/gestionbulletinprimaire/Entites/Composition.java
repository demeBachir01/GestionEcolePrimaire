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
public class Composition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomCompo;
    @ManyToOne
    private Eleve eleve;
    @OneToMany
    private Collection<Matiere> matiere;
    @ManyToMany
    private Collection<Semestre> semestre;

}
