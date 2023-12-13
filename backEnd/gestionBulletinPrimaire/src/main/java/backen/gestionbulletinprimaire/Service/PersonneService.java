package backen.gestionbulletinprimaire.Service;

import backen.gestionbulletinprimaire.DTO.PersonneDto;
import backen.gestionbulletinprimaire.Entites.Personne;
import backen.gestionbulletinprimaire.Repository.PersonneRepository;
import backen.gestionbulletinprimaire.mapper.Personnemapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//@AllArgsConstructor
@Data
public class PersonneService {
    @Autowired
    private PersonneRepository personneRepository;
    private Personnemapper  personnemapper=new Personnemapper();

    // Méthode pour récupérer toutes les personnes
    public List<PersonneDto> listAllPersonnes() {
        List<Personne> personneList=personneRepository.findAll();
        List<PersonneDto> personneDtoList=new ArrayList<>();
        for(Personne p:personneList) {
            PersonneDto personneDto = new PersonneDto();
            personneDto = personnemapper.fromPersonneToPersonneDto(p);
            personneDtoList.add(personneDto);
        }
        return personneDtoList;
    }

    // Méthode pour récupérer une personne par son ID
    public PersonneDto getPersonneById(Long id) {
        Personne personnes = personneRepository.findById(id).get();
        return personnemapper.fromPersonneToPersonneDto(personnes);
    }

    // Méthode pour ajouter une personne
    public PersonneDto addPersonne(PersonneDto personneDto) {
        //personnemapper =new Personnemapper();
      Personne personne=personnemapper.fromPersonneDToPersonne(personneDto);
      return personnemapper.fromPersonneToPersonneDto(personneRepository.save(personne));
    }

    // Méthode pour mettre à jour une personne
    public void updatePersonne( PersonneDto personneDto) {
         Personne personnes = personneRepository.findById(personneDto.getId()).get();
         if (personneDto != null) {
             personnes.setNom(personneDto.getNom());
             personnes.setPrenom(personneDto.getPrenom());
             personnes.setAdresse(personneDto.getAdresse());
             personnes.setTelephone(personneDto.getTelephone());
             personnes.setTelephone(personneDto.getEmail());
             personneRepository.save(personnes);
         }

    }

    // Méthode pour supprimer une personne par son ID
    public void deletePersonne(Long id) {
        Personne personnes = personneRepository.findById(id).orElse(null);
        if (personnes != null) {
            personneRepository.delete(personnes);
        }
    }
}
