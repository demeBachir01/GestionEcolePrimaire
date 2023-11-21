package backen.gestionbulletinprimaire.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class EtablissementDto {
    private Long id;
    private String nomEtablissement;

    private DirecteurDto directeurDto;

    private List<MaitreDto> maitreDto;

    private List<LicenceDto> licenceDto;

    private SecretaireDto secretaireDto;
}
