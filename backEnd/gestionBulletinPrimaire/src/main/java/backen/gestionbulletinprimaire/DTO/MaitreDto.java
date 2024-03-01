package backen.gestionbulletinprimaire.DTO;

import lombok.Data;

import java.util.List;

@Data
//@Builder
public class MaitreDto extends PersonneDto{
    private Long id;
    private EtablissementDto etablissementDto;
    private List<ClasseDto> classeDto;
}
