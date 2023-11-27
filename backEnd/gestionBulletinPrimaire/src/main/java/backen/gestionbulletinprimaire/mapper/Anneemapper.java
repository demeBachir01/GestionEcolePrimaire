package backen.gestionbulletinprimaire.mapper;

import backen.gestionbulletinprimaire.DTO.AnneeDto;
import backen.gestionbulletinprimaire.Entites.Annee;
import org.springframework.beans.BeanUtils;

public class Anneemapper {
    public AnneeDto fromAnneeToAnneeDto(Annee annee){
        AnneeDto anneeDto=new AnneeDto();
        BeanUtils.copyProperties(annee,anneeDto);
        return  anneeDto;
    }

    public  Annee fromAnneeDTOAnnee(AnneeDto anneeDto){
        Annee annee=new Annee();
        BeanUtils.copyProperties(anneeDto,annee);
        return annee;
    }
}

