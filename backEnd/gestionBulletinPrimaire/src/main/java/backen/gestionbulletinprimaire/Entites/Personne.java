package backen.gestionbulletinprimaire.Entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Personne {
    private long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String telephone;
}
