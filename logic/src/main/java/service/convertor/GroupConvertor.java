package service.convertor;

import service.dto.Group;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class GroupConvertor {

    private ClientConvertor clientConvertor;
    private MasterConvertor masterConvertor;

    public Group convert(by.model.Group source) {
        Group result = new Group();
        result.setId(source.getId());
        if (!source.getClients().isEmpty()) {
            result.setClients(source.getClients().stream().map(client -> clientConvertor.convert(client)).collect(Collectors.toList()));
            result.getClients().forEach(client -> client.getGroups().add(result));
        }
        if (source.getMaster() != null) {
            result.setMaster(masterConvertor.convert(source.getMaster()));
            result.getMaster().setGroup(result);
        }
        return result;
    }
}
