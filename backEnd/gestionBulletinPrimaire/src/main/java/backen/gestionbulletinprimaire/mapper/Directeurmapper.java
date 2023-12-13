package backen.gestionbulletinprimaire.mapper;

import backen.gestionbulletinprimaire.DTO.DirecteurDto;
import backen.gestionbulletinprimaire.Entites.Directeur;
import org.springframework.beans.BeanUtils;

public class Directeurmapper {
    public DirecteurDto fromDirecteurToDirecteurDto(Directeur directeur){
        DirecteurDto directeurDto=new DirecteurDto();
        BeanUtils.copyProperties(directeur,directeurDto);
        return directeurDto;
    }

    public Directeur  fromDirecteurDToDirecteur(DirecteurDto directeurDto){
        Directeur directeur=new Directeur();
        BeanUtils.copyProperties(directeurDto,directeur);
        return directeur;
    }
}
