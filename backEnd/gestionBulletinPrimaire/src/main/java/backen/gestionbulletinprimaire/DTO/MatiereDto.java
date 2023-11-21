package backen.gestionbulletinprimaire.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MatiereDto {
    private Long id;
    private String libelle;
    private Double note;

    private CompositionDto compositionDto;


}
