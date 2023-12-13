package backen.gestionbulletinprimaire.Controller;

import backen.gestionbulletinprimaire.DTO.CompositionDto;
import backen.gestionbulletinprimaire.Service.CompositionService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("Composition")
@AllArgsConstructor
@NoArgsConstructor
public class CompositionController {

    @Autowired
    private CompositionService compositionService;
    @GetMapping("All")
    public List<CompositionDto> getAll(){
        return compositionService.listAllComposition();
    }

    // Méthode pour ajouter une Annee
    @PostMapping("Add")
    public CompositionDto addComposition(@RequestBody CompositionDto compositionDto){
        return compositionService.addComposition(compositionDto);
    }
    // Méthode pour récupérer une Annee par son ID
    @GetMapping("getById")
    public CompositionDto getCompositionById(@RequestParam("id") Long id){
        return compositionService.getCompositionById(id);

    }

}
