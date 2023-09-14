package service.convertor;

import service.dto.Master;
import org.springframework.stereotype.Component;

@Component
public class MasterConvertor extends PersonConvertor<Master, by.model.Master> {

    @Override
    public Master convert(by.model.Master source) {
        Master result = super.convert(source);
        result.setId(source.getId());
        return result;
    }
}
