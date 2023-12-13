package backen.gestionbulletinprimaire.Controller;

import backen.gestionbulletinprimaire.DTO.EleveDto;
import backen.gestionbulletinprimaire.Service.EleveService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("Eleve")
@AllArgsConstructor
@NoArgsConstructor
public class EleveController {
    @Autowired
    private EleveService eleveService;

    // Méthode pour récupérer toutes les personnes
    @GetMapping("All")
    public List<EleveDto> getAll(){
        return eleveService.listAllEleve();
    }

    // Méthode pour ajouter une personne
    @PostMapping("Add")
    public EleveDto addEleve(@RequestBody EleveDto eleveDto){
        return eleveService.addEleve(eleveDto);
    }
    // Méthode pour récupérer une personne par son ID
    @GetMapping("getById")
    public  EleveDto getEleveById(@RequestParam("id") Long id){
        return eleveService.getEleveById(id);
    }
}
