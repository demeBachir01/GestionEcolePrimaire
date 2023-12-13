package backen.gestionbulletinprimaire.Service;

import backen.gestionbulletinprimaire.DTO.LicenceDto;
import backen.gestionbulletinprimaire.Entites.Etablissement;
import backen.gestionbulletinprimaire.Entites.Licence;
import backen.gestionbulletinprimaire.Repository.EtablissementRepository;
import backen.gestionbulletinprimaire.Repository.LicenceRepository;
import backen.gestionbulletinprimaire.mapper.Licencemapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class LicenceService {
    @Autowired
    private LicenceRepository licenceRepository;
    @Autowired
    private EtablissementRepository etablissementRepository;
    private Licencemapper licencemapper=new Licencemapper();

    // Méthode pour récupérer toutes les Licence
    public List<LicenceDto> listAllLicence(){
        List<Licence> licences=licenceRepository.findAll();
        List<LicenceDto> licenceDtos=new ArrayList<>();
        for(Licence l:licences) {
            LicenceDto licenceDto = new LicenceDto();
            licenceDto = licencemapper.fromLicenceToLicenceDto(l);
            licenceDtos.add(licenceDto);
        }
        return licenceDtos;
    }


    // Méthode pour récupérer une licence par son ID
    public LicenceDto getLicenceById(Long id) {
        Licence licence = licenceRepository.findById(id).get();
        return licencemapper.fromLicenceToLicenceDto(licence);
    }

    // Méthode pour ajouter une Licence
    public LicenceDto addLicence(LicenceDto licenceDto) {
        Licence licence=licencemapper.fromLicenceDToLicence(licenceDto);
        return licencemapper.fromLicenceToLicenceDto(licenceRepository.save(licence));
    }

    // Méthode pour mettre à jour une Licence
    public void updateLicence( LicenceDto licenceDto) {
        Licence licence = licenceRepository.findById(licenceDto.getId()).get();
        if (licence != null) {
            licence.setId(licence.getId());
            licence.setCode(licence.getCode());
            licence.setDateDebut(licence.getDateDebut());
            licence.setDateFin(licence.getDateFin());
            licence.setEtablissement(new Etablissement());
            licenceRepository.save(licence);
        }
    }

    // Méthode pour supprimer une Licence par son ID
    public void deleteLicence(Long id) {
        Licence licence = licenceRepository.findById(id).orElse(null);
        if (licence != null) {
            licenceRepository.delete(licence);
        }
    }
}
