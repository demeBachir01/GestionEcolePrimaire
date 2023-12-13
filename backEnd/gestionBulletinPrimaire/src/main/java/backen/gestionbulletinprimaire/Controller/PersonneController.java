package backen.gestionbulletinprimaire.Controller;

import backen.gestionbulletinprimaire.DTO.PersonneDto;
import backen.gestionbulletinprimaire.Service.PersonneService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("Personne")
@AllArgsConstructor
@NoArgsConstructor
public class PersonneController {
    @Autowired
    private PersonneService personneService;


    // Méthode pour récupérer toutes les personnes
    @GetMapping("All")
    public List<PersonneDto> getAll(){
        return personneService.listAllPersonnes();
    }

    // Méthode pour ajouter une personne
    @PostMapping ("Add")
    public PersonneDto addPersonne(@RequestBody PersonneDto personneDto){
        return personneService.addPersonne(personneDto);
    }
    // Méthode pour récupérer une personne par son ID
     @GetMapping("getById")
    public  PersonneDto getPersonneById(@RequestParam("id") Long id){
        return personneService.getPersonneById(id);
    }
}
