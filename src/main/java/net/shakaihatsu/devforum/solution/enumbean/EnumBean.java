package net.shakaihatsu.devforum.solution.enumbean;

public interface EnumBean <B, E extends Enum<E> & BeanHolder<B>> {
    E getCorrespondingEnumElement();
}
