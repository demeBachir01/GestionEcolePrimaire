package backen.gestionbulletinprimaire.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder
public class LicenceDto {
    private Long id;
    private Long code;
    private Date dateDebut;
    private Date dateFin;

    private EtablissementDto etablissementDto;


}
