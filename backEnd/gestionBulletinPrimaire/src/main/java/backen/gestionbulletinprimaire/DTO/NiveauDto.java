package backen.gestionbulletinprimaire.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class NiveauDto {
    private Long id;
    private String nom;
    private List<ClasseDto> classeDto;
}
