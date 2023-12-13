package backen.gestionbulletinprimaire.Service;

import backen.gestionbulletinprimaire.DTO.SecretaireDto;
import backen.gestionbulletinprimaire.Entites.Etablissement;
import backen.gestionbulletinprimaire.Entites.Secretaire;
import backen.gestionbulletinprimaire.Repository.EtablissementRepository;
import backen.gestionbulletinprimaire.Repository.PersonneRepository;
import backen.gestionbulletinprimaire.Repository.SecretaireRepository;
import backen.gestionbulletinprimaire.mapper.Secretairemapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class SecretaireService {
    @Autowired
    private SecretaireRepository secretaireRepository;
    @Autowired
    private PersonneRepository personneRepository;
    @Autowired
    private EtablissementRepository etablissementRepository;
    private Secretairemapper secretairemapper =new Secretairemapper();


    // Méthode pour récupérer toutes les Secretaire
    public List<SecretaireDto> listAllSecretaire(){
        List<Secretaire> secretaires=secretaireRepository.findAll();
        List<SecretaireDto> secretaireDtos=new ArrayList<>();
        for(Secretaire sec:secretaires) {
            SecretaireDto secretaireDto = new SecretaireDto();
            secretaireDto=secretairemapper.fromSecretaireToSecretaireDto(sec);
            secretaireDtos.add(secretaireDto);
        }
        return secretaireDtos;
    }


    // Méthode pour récupérer une Secretaire par son ID
    public SecretaireDto getSecretaireById(Long id) {
        Secretaire secretaire = secretaireRepository.findById(id).get();
        return secretairemapper.fromSecretaireToSecretaireDto(secretaire);
    }

    // Méthode pour ajouter une Secretaire
    public SecretaireDto addSecretaire(SecretaireDto secretaireDto) {
        //personnemapper =new Personnemapper();
        Secretaire secretaire=secretairemapper.fromSecretaireDToSecretaire(secretaireDto);
        return secretairemapper.fromSecretaireToSecretaireDto(secretaireRepository.save(secretaire));
    }

    // Méthode pour mettre à jour une Secretaire
    public void updateSecretaire( SecretaireDto secretaireDto) {
        Secretaire secretaire = secretaireRepository.findById(secretaireDto.getId()).get();
        if (secretaire != null) {
            secretaire.setId(secretaireDto.getId());
            secretaire.setNom(secretaireDto.getNom());
            secretaire.setPrenom(secretaireDto.getPrenom());
            secretaire.setAdresse(secretaireDto.getAdresse());
            secretaire.setEmail(secretaireDto.getEmail());
            secretaire.setTelephone(secretaireDto.getTelephone());
            secretaire.setEtablissement(new Etablissement());

            secretaireRepository.save(secretaire);
        }
    }

    // Méthode pour supprimer une Secretaire par son ID
    public void deleteSecretaire(Long id) {
        Secretaire secretaire = secretaireRepository.findById(id).orElse(null);
        if (secretaire != null) {
            secretaireRepository.delete(secretaire);
        }
    }
}
