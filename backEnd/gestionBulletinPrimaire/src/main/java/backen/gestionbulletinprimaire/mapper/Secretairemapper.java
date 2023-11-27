package backen.gestionbulletinprimaire.mapper;

import backen.gestionbulletinprimaire.DTO.SecretaireDto;
import backen.gestionbulletinprimaire.Entites.Secretaire;
import org.springframework.beans.BeanUtils;

public class Secretairemapper {

    public SecretaireDto fromSecretaireToSecretaireDto(Secretaire secretaire){
        SecretaireDto secretaireDto=new SecretaireDto();
        BeanUtils.copyProperties(secretaire,secretaireDto);
        return secretaireDto;
    }

    public Secretaire fromSecretaireDToSecretaire(SecretaireDto secretaireDto){
        Secretaire secretaire =new Secretaire();
        BeanUtils.copyProperties(secretaireDto,secretaire);
        return secretaire;
    }
}
