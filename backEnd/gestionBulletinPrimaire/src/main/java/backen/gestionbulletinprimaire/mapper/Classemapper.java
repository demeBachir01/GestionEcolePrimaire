package backen.gestionbulletinprimaire.mapper;

import backen.gestionbulletinprimaire.DTO.ClasseDto;
import backen.gestionbulletinprimaire.Entites.Classe;
import org.springframework.beans.BeanUtils;

public class Classemapper {

    public ClasseDto fromClasseToClasseDto(Classe classe){

        ClasseDto classeDto=new ClasseDto();
        BeanUtils.copyProperties(classe,classeDto);
        return classeDto;
    }

    public Classe fromClasseDTOclasse(ClasseDto classeDto){
     Classe classe=new Classe();
     BeanUtils.copyProperties(classeDto,classe);
     return classe;
    }
}
