package backen.gestionbulletinprimaire.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class ClasseDto {
    private Long id;
    private String nomClasse;

    private List<MaitreDto> maitreDto;
    private NiveauDto niveauDto;

    private List<EleveDto> eleveDto;


}
