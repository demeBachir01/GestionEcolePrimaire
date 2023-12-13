package backen.gestionbulletinprimaire.Service;

import backen.gestionbulletinprimaire.DTO.SemestreDto;
import backen.gestionbulletinprimaire.Entites.Semestre;
import backen.gestionbulletinprimaire.Repository.SemestreRepository;
import backen.gestionbulletinprimaire.mapper.Semestremapper;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class SemestreService {
    private SemestreRepository semestreRepository;
    private Semestremapper semestremapper;

    // Méthode pour récupérer toutes les Semestre
    public List<SemestreDto> listAllSemestre(){
        List<Semestre> semestres=semestreRepository.findAll();
        List<SemestreDto> secretaireDtos=new ArrayList<>();
        for(Semestre sm:semestres) {
            SemestreDto semestreDto = new SemestreDto();
            semestreDto=semestremapper.fromSemestreToSemestreDto(sm);
            secretaireDtos.add(semestreDto);
        }
        return secretaireDtos;
    }


    // Méthode pour récupérer une Semestre par son ID
    public SemestreDto getSemestreById(Long id) {
        Semestre semestre = semestreRepository.findById(id).get();
        return semestremapper.fromSemestreToSemestreDto(semestre);
    }

    // Méthode pour ajouter une Semestre
    public SemestreDto addSemestre(SemestreDto semestreDto) {
        Semestre semestre=semestremapper.fromSemestreDToSemestre(semestreDto);
        return semestremapper.fromSemestreToSemestreDto(semestreRepository.save(semestre));
    }

    // Méthode pour mettre à jour une Semestre
    public void updateSemestre( SemestreDto semestreDto) {
        Semestre semestre = semestreRepository.findById(semestreDto.getId()).get();
        if (semestre != null) {
            semestre.setId(semestreDto.getId());
            semestre.setNumSemestre(semestre.getNumSemestre());
            semestreRepository.save(semestre);
        }
    }

    // Méthode pour supprimer une Semestre par son ID
    public void deleteSemestre(Long id) {
        Semestre semestre = semestreRepository.findById(id).orElse(null);
        if (semestre != null) {
            semestreRepository.delete(semestre);
        }
    }
}
