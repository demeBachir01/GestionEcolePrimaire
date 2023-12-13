package backen.gestionbulletinprimaire.Controller;

import backen.gestionbulletinprimaire.DTO.AnneeDto;
import backen.gestionbulletinprimaire.Service.AnneeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("Annee")
@AllArgsConstructor
@NoArgsConstructor
public class AnneeController {
    @Autowired
    private AnneeService anneeService;
    @GetMapping("All")
    public List<AnneeDto> getAll(){
        return anneeService.listAllAnnee();
    }

    // Méthode pour ajouter une Annee
    @PostMapping("Add")
    public AnneeDto addPersonne(@RequestBody AnneeDto anneeDto){
        return anneeService.AddAnnee(anneeDto);
    }
    // Méthode pour récupérer une Annee par son ID
    @GetMapping("getById")
    public  AnneeDto geAnneeById(@RequestParam("id") Long id){
        return anneeService.getAnneeById(id);
    }
}
