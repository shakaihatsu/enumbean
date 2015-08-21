package net.shakaihatsu.devforum.solution.enumbean;

import javax.annotation.PostConstruct;

public abstract class AbstractEnumBean<B, E extends Enum<E> & BeanHolder<B>> implements EnumBean<B, E> {
	@PostConstruct
	@SuppressWarnings("unchecked")
	public void init() {
        getCorrespondingEnumElement().setBean((B) this);
    }
}
