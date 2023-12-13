package backen.gestionbulletinprimaire.Service;

import backen.gestionbulletinprimaire.DTO.ClasseDto;
import backen.gestionbulletinprimaire.Entites.Classe;
import backen.gestionbulletinprimaire.Entites.Niveau;
import backen.gestionbulletinprimaire.Repository.ClasseRepository;
import backen.gestionbulletinprimaire.Repository.NiveauRepository;
import backen.gestionbulletinprimaire.mapper.Classemapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class ClasseService {
    @Autowired
    private ClasseRepository classeRepository;
    @Autowired
    private NiveauRepository niveauRepository;
    private Classemapper classemapper=new Classemapper();

    // Méthode pour récupérer toutes les Classe
    public List<ClasseDto> lisAllClasse(){
        List<Classe> classeList=classeRepository.findAll();
        List<ClasseDto> classeDtos=new ArrayList<>();
        for(Classe c:classeList){
            ClasseDto classeDto =new ClasseDto();
            classeDto =classemapper.fromClasseToClasseDto(c);
            classeDtos.add(classeDto);
        }
        return classeDtos;
    }

    // Méthode pour récupérer une classe par son ID
    public ClasseDto getClasseById(Long id) {
        Classe classe = classeRepository.findById(id).get();
        return classemapper.fromClasseToClasseDto(classe);
    }

    // Méthode pour ajouter une classe
    public ClasseDto addClasse(ClasseDto classeDto) {
        Classe classe=classemapper.fromClasseDTOclasse(classeDto);
        return classemapper.fromClasseToClasseDto(classeRepository.save(classe));
    }

    // Méthode pour mettre à jour une classe
    public void updateClasse( ClasseDto classeDto) {
        Classe classe = classeRepository.findById(classeDto.getId()).get();
        if (classeDto != null) {
            classe.setId(classeDto.getId());
            classe.setNomClasse(classeDto.getNomClasse());
            classe.setNiveaux(new Niveau());
            classe.setMaitres(new ArrayList<>());
            classe.setEleves(new ArrayList<>());
            classeRepository.save(classe);
        }
    }

    // Méthode pour supprimer une personne par son ID
    public void deleteClasse(Long id) {
        Classe classe = classeRepository.findById(id).orElse(null);
        if (classe != null) {
            classeRepository.delete(classe);
        }
    }


}
