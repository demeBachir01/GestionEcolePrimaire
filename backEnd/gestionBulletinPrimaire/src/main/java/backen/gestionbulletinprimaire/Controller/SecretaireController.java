package backen.gestionbulletinprimaire.Controller;

import backen.gestionbulletinprimaire.DTO.SecretaireDto;
import backen.gestionbulletinprimaire.Service.SecretaireService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("Secretaire")
@AllArgsConstructor
@NoArgsConstructor
public class SecretaireController {
    @Autowired
    private SecretaireService secretaireService;

    @GetMapping("All")
    public List<SecretaireDto> getAll(){
        return secretaireService.listAllSecretaire();
    }

    // Méthode pour ajouter une Directeur
    @PostMapping("Add")
    public SecretaireDto addSecretaire(@RequestBody SecretaireDto secretaireDto){
        return secretaireService.addSecretaire(secretaireDto);
    }
    // Méthode pour récupérer une Directeur par son ID
    @GetMapping("getById")
    public SecretaireDto getSecretaireById(@RequestParam("id") Long id){
        return secretaireService.getSecretaireById(id);

    }
}
