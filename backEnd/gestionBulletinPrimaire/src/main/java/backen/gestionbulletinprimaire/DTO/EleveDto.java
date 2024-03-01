package backen.gestionbulletinprimaire.DTO;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
//@Builder
public class EleveDto extends PersonneDto {
    private  Long id;
    private Long matricule;
    private Date dateNaissance;
    private String lieuDeNaissance;
    private List<ClasseDto> classeDto;
    private List<CompositionDto> compositionDto;
}
