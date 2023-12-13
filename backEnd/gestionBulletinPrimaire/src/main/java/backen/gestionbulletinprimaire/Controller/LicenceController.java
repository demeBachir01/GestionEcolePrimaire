package backen.gestionbulletinprimaire.Controller;

import backen.gestionbulletinprimaire.DTO.LicenceDto;
import backen.gestionbulletinprimaire.Service.LicenceService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("Licence")
@AllArgsConstructor
@NoArgsConstructor
public class LicenceController {
    @Autowired
    private LicenceService licenceService;

    @GetMapping("All")
    public List<LicenceDto> getAll(){
        return licenceService.listAllLicence();
    }

    // Méthode pour ajouter une Directeur
    @PostMapping("Add")
    public LicenceDto addLicence(@RequestBody LicenceDto licenceDto){
        return licenceService.addLicence(licenceDto);
    }
    // Méthode pour récupérer une Directeur par son ID
    @GetMapping("getById")
    public LicenceDto getLicenceById(@RequestParam("id") Long id){
        return licenceService.getLicenceById(id);

    }
}
