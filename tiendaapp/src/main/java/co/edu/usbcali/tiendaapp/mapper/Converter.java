package co.edu.usbcali.tiendaapp.mapper;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Converter<T, U> {

    private final Function<T, U> fromDto;
    private final Function<U, T> fromEntity;

    public Converter(final Function<T, U> fromDto, final Function<U, T> fromEntity) {
        this.fromDto = fromDto;
        this.fromEntity = fromEntity;
    }

    public final U dtoToDomain(final T dto) {
        return fromDto.apply(dto);
    }

    public final T domainToDto(final U entity) {
        return fromEntity.apply(entity);
    }

    public final List<U> dtoToDomainList(final Collection<T> dtos) {
        return dtos.stream().map(this::dtoToDomain).collect(Collectors.toList());
    }

    public final List<T> domainToDtoList(final Collection<U> entities) {
        return entities.stream().map(this::domainToDto).collect(Collectors.toList());
    }
}