package backen.gestionbulletinprimaire.Entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "secretaire")
public class Secretaire extends Personne {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Long id;
    @OneToOne(mappedBy = "secretaire")
    private Etablissement etablissement;
}
