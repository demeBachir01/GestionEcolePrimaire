package backen.gestionbulletinprimaire.DTO;

import lombok.Data;

import java.util.List;

@Data
//@Builder
public class CompositionDto {
    private Long id;
    private String nomCompo;
    private EleveDto eleveDto;
    private List<SemestreDto> semestreDto;
    private List<MatiereDto> matiereDto;
}
