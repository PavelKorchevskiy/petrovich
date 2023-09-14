package service.convertor;

import service.dto.Person;

public class PersonConvertor<T extends Person, K extends by.model.Person> {

    public T convert(K source) {
        Person result = new Person();
        result.setAge(source.getAge());
        result.setFirstName(source.getFirstName());
        result.setLastName(source.getLastName());
        return (T) result;
    }
}
