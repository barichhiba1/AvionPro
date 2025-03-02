package org.sid.testprep.web;

import lombok.AllArgsConstructor;
import org.sid.testprep.dao.entities.Avion;
import org.sid.testprep.dto.AvionDto;
import org.sid.testprep.service.AvionService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class AvionGraphQLController {
    private AvionService avionService ;
    @MutationMapping
    public AvionDto saveAvion(@Argument AvionDto avion){
        return avionService.saveAvion(avion);
    }
    @MutationMapping
    public  Boolean deleteAvion(@Argument Long id ){
        return avionService.deleteAvion(id);
    }
    @QueryMapping
    public List<AvionDto>getAvionByModel(@Argument String model){
        return avionService.getAvionByModel(model);
    }
    @QueryMapping
    public List<AvionDto>getAvionByModelAndPrice(@Argument String model ,@Argument double price ){
        return avionService.getAvionByModelAndPrice(model, price);
    }
}
