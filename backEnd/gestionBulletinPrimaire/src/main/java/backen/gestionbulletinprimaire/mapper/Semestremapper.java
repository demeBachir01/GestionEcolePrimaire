package backen.gestionbulletinprimaire.mapper;

import backen.gestionbulletinprimaire.DTO.SemestreDto;
import backen.gestionbulletinprimaire.Entites.Semestre;
import org.springframework.beans.BeanUtils;

public class Semestremapper {

    public SemestreDto fromSemestreToSemestreDto(Semestre semestre){
        SemestreDto semestreDto=new SemestreDto();
        BeanUtils.copyProperties(semestre,semestreDto);
        return  semestreDto;
    }
    public Semestre fromSemestreDToSemestre(SemestreDto semestreDto){
        Semestre semestre=new Semestre();
        BeanUtils.copyProperties(semestreDto,semestre);
        return semestre;
    }
}
