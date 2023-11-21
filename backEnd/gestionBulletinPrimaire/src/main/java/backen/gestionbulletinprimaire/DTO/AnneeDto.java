package backen.gestionbulletinprimaire.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
@Builder
public class AnneeDto {
    private Long id;
    private Date dateDebut;
    private Date dateFin;
    private List<SemestreDto> semestreDto;
}
