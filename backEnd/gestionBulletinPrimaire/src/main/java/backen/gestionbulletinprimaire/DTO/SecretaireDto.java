package backen.gestionbulletinprimaire.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SecretaireDto {
    private  Long id;
    private EtablissementDto etablissementDto;
}
