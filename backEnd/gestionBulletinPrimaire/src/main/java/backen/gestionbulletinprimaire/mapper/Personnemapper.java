package backen.gestionbulletinprimaire.mapper;

import backen.gestionbulletinprimaire.DTO.PersonneDto;
import backen.gestionbulletinprimaire.Entites.Personne;
import org.springframework.beans.BeanUtils;

public class Personnemapper {
    public PersonneDto fromPersonneToPersonneDto(Personne personne){
        PersonneDto personneDto=new PersonneDto();
        BeanUtils.copyProperties(personne,personneDto);
       return  personneDto;
    }

    public  Personne fromPersonne_To_Personne(PersonneDto personneDto){
        Personne personne=new Personne();
        BeanUtils.copyProperties(personneDto,personne);
        return personne;
    }
}
