package backen.gestionbulletinprimaire.Service;

import backen.gestionbulletinprimaire.DTO.EleveDto;
import backen.gestionbulletinprimaire.Entites.Eleve;
import backen.gestionbulletinprimaire.Repository.EleveRepository;
import backen.gestionbulletinprimaire.Repository.PersonneRepository;
import backen.gestionbulletinprimaire.mapper.Elevemapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class EleveService {
    @Autowired
    private EleveRepository eleveRepository;
    private Elevemapper elevemapper=new Elevemapper();
    @Autowired
    private PersonneRepository personneRepository;

    // Méthode pour récupérer toutes les Eleves
    public List<EleveDto> listAllEleve(){
        List<Eleve> eleves=eleveRepository.findAll();
        List<EleveDto> eleveDtos=new ArrayList<>();
        for(Eleve e:eleves) {
            EleveDto eleveDto = new EleveDto();
            eleveDto = elevemapper.formEleveToEleveDto(e);
            eleveDtos.add(eleveDto);
        }
        return eleveDtos;
    }


    // Méthode pour récupérer une Eleves par son ID
    public EleveDto getEleveById(Long id) {
        Eleve eleve = eleveRepository.findById(id).get();
        return elevemapper.formEleveToEleveDto(eleve);
    }

    // Méthode pour ajouter une Eleves
    public EleveDto addEleve(EleveDto eleveDto) {
        Eleve eleve=elevemapper.fromEleveDToEleve(eleveDto);
        return elevemapper.formEleveToEleveDto(eleveRepository.save(eleve));
    }

    // Méthode pour mettre à jour une eleve
    public void updateEleve( EleveDto eleveDto) {
        Eleve eleve = eleveRepository.findById(eleveDto.getId()).get();
       // Personne personne=personneRepository.findById();
        if (eleveDto != null) {
            eleve.setId(eleveDto.getId());
            eleve.setNom(eleveDto.getNom());
            eleve.setPrenom(eleveDto.getPrenom());
            eleve.setAdresse(eleveDto.getAdresse());
            eleve.setEmail(eleveDto.getEmail());
            eleve.setTelephone(eleveDto.getTelephone());
            eleve.setMatricule(eleveDto.getMatricule());
            eleve.setDateNaissance(eleveDto.getDateNaissance());
            eleve.setLieuDeNaissance(eleveDto.getLieuDeNaissance());

            eleveRepository.save(eleve);
        }
    }

    // Méthode pour supprimer une Eleve par son ID
    public void deleteEleve(Long id) {
        Eleve eleve = eleveRepository.findById(id).orElse(null);
        if (eleve != null) {
            eleveRepository.delete(eleve);
        }
    }
}
