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
@Table(name = "eleve")
@PrimaryKeyJoinColumn(name = "id")
public class Eleve extends  Personne {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Long id;
    @Column(nullable = false)
    private Long matricule;
    @Column(nullable = false)
   // @DateTimeFormat(pattern="DD/MM/YYYY")
    private Date dateNaissance;
    @Column(nullable = false)
    private String lieuDeNaissance;
    @ManyToMany
    private List<Classe> classe;
    @OneToMany(mappedBy = "eleve")
    private List<Composition> compositions;

}
