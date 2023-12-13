package backen.gestionbulletinprimaire.Service;

import backen.gestionbulletinprimaire.DTO.AnneeDto;
import backen.gestionbulletinprimaire.Entites.Annee;
import backen.gestionbulletinprimaire.Repository.AnneeRepository;
import backen.gestionbulletinprimaire.mapper.Anneemapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class AnneeService {
    @Autowired
    private AnneeRepository anneeRepository;
    private Anneemapper anneemapper=new Anneemapper();


    // Méthode pour récupérer toutes les personnes
    public List<AnneeDto> listAllAnnee() {
        List<Annee> anneeList = anneeRepository.findAll();
        List<AnneeDto> anneeDtoslist = new ArrayList<>();
        AnneeDto anneeDto = null;
        for (Annee a : anneeList) {
            anneeDto = new AnneeDto();
            anneeDto = anneemapper.fromAnneeToAnneeDto(a);
            anneeDtoslist.add(anneeDto);
        }
        return anneeDtoslist;
    }

    // Méthode pour récupérer une personne par son ID
    public AnneeDto getAnneeById(Long id) {
        Annee annee=anneeRepository.findById(id).get();
        return  anneemapper.fromAnneeToAnneeDto(annee);
    }

    // Méthode pour ajouter une personne
    public AnneeDto AddAnnee(AnneeDto anneeDto){
        Annee annee=anneemapper.fromAnneeDTOAnnee(anneeDto);
        return anneemapper.fromAnneeToAnneeDto(anneeRepository.save(annee));
    }

    // Méthode pour mettre à jour une personne

    public  void updateAnnee(AnneeDto anneeDto){
        Annee annee=anneeRepository.findById(anneeDto.getId()).get();
        if(annee!= null){
            annee.setId(annee.getId());
            annee.setDateDebut(anneeDto.getDateDebut());
            annee.setDateFin(anneeDto.getDateFin());
             anneeRepository.save(annee);
        }
    }

    // Méthode pour supprimer une annee par son ID

    public  void deleteAnnee(Long id) {

        Annee annee=anneeRepository.findById(id).orElse(null);
        if(annee != null){
            anneeRepository.delete(annee);
    }

    }

}
