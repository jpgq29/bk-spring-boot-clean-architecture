package co.com.bancolombia.jpa.common;

import java.util.List;

public interface IConversion<E, D> {
    List<D> listConversion(List<E> data);
    D conversion(E data);
}
