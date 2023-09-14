package service.convertor;

import service.dto.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientConvertor extends PersonConvertor<Client, by.model.Client> {

    public Client convert(by.model.Client source) {
        Client result = super.convert(source);
        result.setId(source.getId());
        result.setRegistrationDate(source.getRegistrationDate());
        return result;
    }
}
