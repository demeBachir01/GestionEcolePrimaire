package backen.gestionbulletinprimaire.mapper;

import backen.gestionbulletinprimaire.DTO.MatiereDto;
import backen.gestionbulletinprimaire.Entites.Matiere;
import org.springframework.beans.BeanUtils;

public class Matieremapper {
    public MatiereDto  fromMatiereToMatiereDto(Matiere matiere){
       MatiereDto matiereDto=new MatiereDto();
        BeanUtils.copyProperties(matiere ,matiereDto);
        return matiereDto;
    }

    public Matiere fromMatiereDToMatiere(MatiereDto matiereDto){
        Matiere matiere=new Matiere();
        BeanUtils.copyProperties(matiereDto,matiere);
        return matiere;
    }
}
