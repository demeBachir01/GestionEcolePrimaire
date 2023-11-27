package backen.gestionbulletinprimaire.mapper;

import backen.gestionbulletinprimaire.DTO.CompositionDto;
import backen.gestionbulletinprimaire.Entites.Composition;
import org.springframework.beans.BeanUtils;

public class Compositionmapper {

    public CompositionDto fromCompositionToCompositionDto(Composition composition){
        CompositionDto compositionDto=new CompositionDto();
        BeanUtils.copyProperties(composition,compositionDto);
        return  compositionDto;
    }

    public Composition fromCompositionDToComposition(CompositionDto compositionDto){
        Composition composition=new Composition();
        BeanUtils.copyProperties(compositionDto,composition);
        return composition;
    }
}
