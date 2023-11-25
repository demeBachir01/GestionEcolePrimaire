package backen.gestionbulletinprimaire.DTO;

import lombok.Data;

import java.util.Date;
@Data
//@Builder

public class AnneeDto {
    private Long id;
    private Date dateDebut;
    private Date dateFin;

}

