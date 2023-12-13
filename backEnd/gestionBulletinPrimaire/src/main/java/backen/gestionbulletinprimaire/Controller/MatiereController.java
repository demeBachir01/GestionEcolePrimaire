package backen.gestionbulletinprimaire.Controller;

import backen.gestionbulletinprimaire.DTO.MatiereDto;
import backen.gestionbulletinprimaire.Service.MatiereService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("Matiere")
@AllArgsConstructor
@NoArgsConstructor
public class MatiereController {
    private MatiereService matiereService;

    @GetMapping("All")
    public List<MatiereDto> getAll(){
        return matiereService.listAllMatiere();
    }

    // Méthode pour ajouter une Directeur
    @PostMapping("Add")
    public MatiereDto addMatiere(@RequestBody MatiereDto matiereDto){
        return matiereService.addMatiere(matiereDto);
    }
    // Méthode pour récupérer une Directeur par son ID
    @GetMapping("getById")
    public MatiereDto getMatiereById(@RequestParam("id") Long id){
        return matiereService.getMatiereById(id);

    }
}
