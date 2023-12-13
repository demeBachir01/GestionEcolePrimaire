package backen.gestionbulletinprimaire.Controller;

import backen.gestionbulletinprimaire.DTO.SemestreDto;
import backen.gestionbulletinprimaire.Service.SemestreService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("Semestre")
@AllArgsConstructor
@NoArgsConstructor
public class SemestreController {

    private SemestreService semestreService;

    @GetMapping("All")
    public List<SemestreDto> getAll(){
        return semestreService.listAllSemestre();
    }

    // Méthode pour ajouter une Directeur
    @PostMapping("Add")
    public SemestreDto addSecretaire(@RequestBody SemestreDto semestreDto){
        return semestreService.addSemestre(semestreDto);
    }
    // Méthode pour récupérer une Directeur par son ID
    @GetMapping("getById")
    public SemestreDto getSecretaireById(@RequestParam("id") Long id){
        return semestreService.getSemestreById(id);

    }
}
