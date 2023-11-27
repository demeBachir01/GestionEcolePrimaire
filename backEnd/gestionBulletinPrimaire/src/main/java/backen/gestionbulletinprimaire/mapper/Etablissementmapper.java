package backen.gestionbulletinprimaire.mapper;

import backen.gestionbulletinprimaire.DTO.EtablissementDto;
import backen.gestionbulletinprimaire.Entites.Etablissement;
import org.springframework.beans.BeanUtils;

public class Etablissementmapper {
    public EtablissementDto fromEtablissemetToEtablissementDto(Etablissement etablissement){
        EtablissementDto etablissementDto=new EtablissementDto();
        BeanUtils.copyProperties(etablissement,etablissementDto);
        return  etablissementDto;
    }

    public Etablissement fromEtablissementDToEtablissement (EtablissementDto etablissementDto){
        Etablissement etablissement=new Etablissement();
        BeanUtils.copyProperties(etablissementDto,etablissement);
        return etablissement;
    }
}
