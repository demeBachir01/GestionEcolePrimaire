package backen.gestionbulletinprimaire.Service;

import backen.gestionbulletinprimaire.DTO.EtablissementDto;
import backen.gestionbulletinprimaire.Entites.Directeur;
import backen.gestionbulletinprimaire.Entites.Etablissement;
import backen.gestionbulletinprimaire.Entites.Secretaire;
import backen.gestionbulletinprimaire.Repository.*;
import backen.gestionbulletinprimaire.mapper.Etablissementmapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class EtablissementService {
    @Autowired
    private EtablissementRepository etablissementRepository;
    @Autowired
    private DirecteurRepository directeurRepository;
    @Autowired
    private SecretaireRepository secretaireRepository;
    @Autowired
    private MaitreRepository maitreRepository;
    @Autowired
    private LicenceRepository licenceRepository;
    private Etablissementmapper etablissementmapper=new Etablissementmapper();


    public List<EtablissementDto> listAllEtablissement(){
        List<Etablissement> etablissements=etablissementRepository.findAll();
        List<EtablissementDto> etablissementDtos=new ArrayList<>();
        for(Etablissement et:etablissements) {
            EtablissementDto etablissementDto = new EtablissementDto();
            etablissementDto = etablissementmapper.fromEtablissemetToEtablissementDto(et);
            etablissementDtos.add(etablissementDto);
        }
        return etablissementDtos;
    }


    // Méthode pour récupérer une Etablissement par son ID
    public EtablissementDto getEtablissementById(Long id) {
        Etablissement etablissement = etablissementRepository.findById(id).get();
        return etablissementmapper.fromEtablissemetToEtablissementDto(etablissement);
    }

    // Méthode pour ajouter une Etablissement
    public EtablissementDto addEtablissement(EtablissementDto etablissementDto) {
        Etablissement etablissement=etablissementmapper.fromEtablissementDToEtablissement(etablissementDto);
        return etablissementmapper.fromEtablissemetToEtablissementDto(etablissementRepository.save(etablissement));
    }

    // Méthode pour mettre à jour une eleve
    public void updateEleve( EtablissementDto etablissementDto) {
        Etablissement etablissement = etablissementRepository.findById(etablissementDto.getId()).get();
        if (etablissementDto != null) {
            etablissement.setId(etablissementDto.getId());
            etablissement.setNomEtablissement(etablissementDto.getNomEtablissement());
            etablissement.setDirecteur(new Directeur());
            etablissement.setSecretaire(new Secretaire());
            etablissement.setMaitres(new ArrayList<>());
            etablissement.setLicences(new ArrayList<>());
            etablissementRepository.save(etablissement);
        }
    }

    // Méthode pour supprimer une Etablissement par son ID
    public void deleteEtablissement(Long id) {
        Etablissement etablissement = etablissementRepository.findById(id).orElse(null);
        if (etablissement != null) {
            etablissementRepository.delete(etablissement);
        }
    }
}
