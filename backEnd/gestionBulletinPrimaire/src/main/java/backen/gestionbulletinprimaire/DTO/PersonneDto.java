package backen.gestionbulletinprimaire.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonneDto {
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String telephone;
}
