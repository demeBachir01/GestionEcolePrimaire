package backen.gestionbulletinprimaire.Controller;

import backen.gestionbulletinprimaire.DTO.MaitreDto;
import backen.gestionbulletinprimaire.Service.MaitreService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("Maitre")
@AllArgsConstructor
@NoArgsConstructor
public class MaitreController {
    private MaitreService maitreService;

    @GetMapping("All")
    public List<MaitreDto> getAll(){
        return maitreService.listAllMaitre();
    }

    // Méthode pour ajouter une Directeur
    @PostMapping("Add")
    public MaitreDto addMaitre(@RequestBody MaitreDto maitreDto){
        return maitreService.addMaitre(maitreDto);
    }
    // Méthode pour récupérer une Directeur par son ID
    @GetMapping("getById")
    public MaitreDto getMaitreById(@RequestParam("id") Long id){
        return maitreService.getMaitreById(id);

    }
}
