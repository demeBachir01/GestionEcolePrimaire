package backen.gestionbulletinprimaire.mapper;

import backen.gestionbulletinprimaire.DTO.MaitreDto;
import backen.gestionbulletinprimaire.Entites.Maitre;
import org.springframework.beans.BeanUtils;

public class Maitremapper {
    public MaitreDto  fromMaitreToMaitreDto(Maitre maitre){
        MaitreDto maitreDto=new MaitreDto();
        BeanUtils.copyProperties(maitre,maitreDto);
        return maitreDto;
    }

    public Maitre fromMaitre_To_Maitre(MaitreDto maitreDto){
        Maitre maitre=new Maitre();
        BeanUtils.copyProperties(maitreDto,maitre);
        return maitre;
    }
}
