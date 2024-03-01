package backen.gestionbulletinprimaire.Entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "matiere")
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String libelle;
    @Column(nullable = false)
    private Double note;
    @ManyToOne
    private Composition composition;
}
