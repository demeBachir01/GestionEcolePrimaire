package backen.gestionbulletinprimaire.DTO;

import lombok.Data;

@Data
//@Builder
public class SecretaireDto extends PersonneDto{
    private  Long id;
    private EtablissementDto etablissementDto;
}
