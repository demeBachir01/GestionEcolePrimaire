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
public class Composition {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nomCompo;
    @ManyToOne
    private Eleve eleve;
    @ManyToMany
    private List<Semestre> semestres;
    @OneToMany(mappedBy = "composition")
    private List<Matiere> matiere;

}
