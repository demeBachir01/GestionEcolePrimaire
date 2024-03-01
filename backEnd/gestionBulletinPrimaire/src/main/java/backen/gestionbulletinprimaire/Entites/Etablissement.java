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
@Table(name = "etablissment")
public class Etablissement {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nomEtablissement;
    @OneToOne
    private Directeur directeur;
    @OneToMany(mappedBy = "etablissements")
    private List<Maitre> maitres;
    @OneToMany
    private List<Licence> licences;
    @OneToOne
    private Secretaire secretaire;
}
