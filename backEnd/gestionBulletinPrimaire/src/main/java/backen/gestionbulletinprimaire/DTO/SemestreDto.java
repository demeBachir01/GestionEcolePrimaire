package backen.gestionbulletinprimaire.DTO;

import lombok.Data;

import java.util.List;

@Data
//@Builder
public class SemestreDto {
    private Long id;
    private Long numSemestre;
    private List<CompositionDto> compositionDto;
    private AnneeDto anneeDto;
}
