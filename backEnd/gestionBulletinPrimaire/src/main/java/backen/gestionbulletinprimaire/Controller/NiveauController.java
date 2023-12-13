package backen.gestionbulletinprimaire.Controller;

import backen.gestionbulletinprimaire.DTO.NiveauDto;
import backen.gestionbulletinprimaire.Service.NiveauService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("Niveau")
@AllArgsConstructor
@NoArgsConstructor
public class NiveauController {
    private NiveauService niveauService;

    @GetMapping("All")
    public List<NiveauDto> getAll(){
        return niveauService.listAllNiveau();
    }

    // Méthode pour ajouter une Directeur
    @PostMapping("Add")
    public NiveauDto addSecretaire(@RequestBody NiveauDto niveauDto){
        return niveauService.addNiveau(niveauDto);
    }
    // Méthode pour récupérer une Directeur par son ID
    @GetMapping("getById")
    public NiveauDto getSecretaireById(@RequestParam("id") Long id){
        return niveauService.getNiveauById(id);

    }
}
