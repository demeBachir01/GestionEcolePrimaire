package backen.gestionbulletinprimaire.mapper;

import backen.gestionbulletinprimaire.DTO.EleveDto;
import backen.gestionbulletinprimaire.Entites.Eleve;
import org.springframework.beans.BeanUtils;

public class Elevemapper {

    public EleveDto formEleveToEleveDDto(Eleve eleve){
        EleveDto eleveDto=new EleveDto();
        BeanUtils.copyProperties(eleve ,eleveDto);
        return eleveDto;

    }

    public Eleve fromEleveDToEleve(EleveDto eleveDto){
        Eleve eleve=new Eleve();
        BeanUtils.copyProperties(eleveDto,eleve);
        return eleve;
    }
}
