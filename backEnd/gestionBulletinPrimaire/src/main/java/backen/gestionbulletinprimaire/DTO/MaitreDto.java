package backen.gestionbulletinprimaire.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class MaitreDto {

    private EtablissementDto etablissementDto;

    private List<ClasseDto> classeDto;
}
