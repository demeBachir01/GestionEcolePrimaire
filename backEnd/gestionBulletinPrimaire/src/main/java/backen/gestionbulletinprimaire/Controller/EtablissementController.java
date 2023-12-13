package backen.gestionbulletinprimaire.Controller;

import backen.gestionbulletinprimaire.DTO.EtablissementDto;
import backen.gestionbulletinprimaire.Service.EtablissementService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("Etablissement")
@AllArgsConstructor
@NoArgsConstructor
public class EtablissementController {
    @Autowired
    private EtablissementService etablissementService;

    @GetMapping("All")
    public List<EtablissementDto> getAll(){
        return etablissementService.listAllEtablissement();
    }

    // Méthode pour ajouter une Directeur
    @PostMapping("Add")
    public EtablissementDto addEtablissement(@RequestBody EtablissementDto etablissementDto){
        return etablissementService.addEtablissement(etablissementDto);
    }
    // Méthode pour récupérer une Directeur par son ID
    @GetMapping("getById")
    public EtablissementDto getEtablissementById(@RequestParam("id") Long id){
        return etablissementService.getEtablissementById(id);

    }
}
