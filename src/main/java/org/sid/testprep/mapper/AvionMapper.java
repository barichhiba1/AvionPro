package org.sid.testprep.mapper;

import org.modelmapper.ModelMapper;
import org.sid.testprep.dao.entities.Avion;
import org.sid.testprep.dto.AvionDto;
import org.springframework.stereotype.Component;

@Component
public class AvionMapper {
    private  final ModelMapper mapper = new ModelMapper();
    public Avion fromAvionDtoToAvion(AvionDto avionDto){ return  mapper.map(avionDto, Avion.class);}

    public  AvionDto fromAvionToAvionDto(Avion avion ){return mapper.map(avion,AvionDto.class);}

}
