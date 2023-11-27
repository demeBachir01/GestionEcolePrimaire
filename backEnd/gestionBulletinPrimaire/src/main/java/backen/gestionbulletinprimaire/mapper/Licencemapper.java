package backen.gestionbulletinprimaire.mapper;

import backen.gestionbulletinprimaire.DTO.LicenceDto;
import backen.gestionbulletinprimaire.Entites.Licence;
import org.springframework.beans.BeanUtils;

public class Licencemapper {
    public LicenceDto fromLicenceToLicenceDto(Licence licence){
        LicenceDto licenceDto=new LicenceDto();
        BeanUtils.copyProperties(licence,licenceDto);
        return licenceDto;
    }

    public Licence fromLicenceDToLicence(LicenceDto licenceDto){
        Licence licence=new Licence();
        BeanUtils.copyProperties(licenceDto,licence);
        return licence;
    }
}
