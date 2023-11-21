package backen.gestionbulletinprimaire.DTO;

import backen.gestionbulletinprimaire.Entites.Eleve;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class CompositionDto {
    private Long id;
    private String nomCompo;

    private Eleve eleve;

    private List<SemestreDto> semestreDto;

    private List<MatiereDto> matiereDto;
}
