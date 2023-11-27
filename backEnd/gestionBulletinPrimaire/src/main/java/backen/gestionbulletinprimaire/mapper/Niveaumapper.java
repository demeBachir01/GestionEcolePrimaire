package backen.gestionbulletinprimaire.mapper;

import backen.gestionbulletinprimaire.DTO.NiveauDto;
import backen.gestionbulletinprimaire.Entites.Niveau;
import org.springframework.beans.BeanUtils;

public class Niveaumapper {

    public NiveauDto fromNiveauToNiveauDto(Niveau niveau){
        NiveauDto niveauDto =new NiveauDto();
        BeanUtils.copyProperties(niveau,niveauDto);
        return  niveauDto;
    }

    public  Niveau fromNiveauDToNiveau(NiveauDto niveauDto){
        Niveau niveau=new Niveau();
        BeanUtils.copyProperties(niveauDto,niveau);
        return niveau;
    }


}
