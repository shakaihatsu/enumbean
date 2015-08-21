package net.shakaihatsu.devforum.solution.enumbean.simple;

import java.util.HashMap;
import java.util.Map;

import net.shakaihatsu.devforum.api.TaskProcessor;
import net.shakaihatsu.devforum.domain.Status;
import net.shakaihatsu.devforum.domain.Task;

public enum StatusExtender implements TaskProcessor {
	NEW(Status.NEW, new NewTaskProcessor()), FAILED(Status.FAILED,
			new FailedTaskProcessor()), SUCCESSFUL(Status.SUCCESSFUL,
			new SuccessfulTaskProcessor()), CANCELED(Status.CANCELED,
			new CanceledTaskProcessor());

	private TaskProcessor bean;

	@Override
	public int processTask(Task task) {
		return bean.processTask(task);
	}

	private static final Map<Status, StatusExtender> ORIGINAL_TO_EXTENDER;
	private static final Map<StatusExtender, Status> EXTENDER_TO_ORIGINAL;

	private final Status original;

	static {
		ORIGINAL_TO_EXTENDER = new HashMap<>();
		EXTENDER_TO_ORIGINAL = new HashMap<>();

		StatusExtender[] extenders = StatusExtender.values();
		for (StatusExtender extender : extenders) {
			ORIGINAL_TO_EXTENDER.put(extender.original, extender);
			EXTENDER_TO_ORIGINAL.put(extender, extender.original);
		}

		assertFullMapping();
	}

	private StatusExtender(Status original, TaskProcessor bean) {
		this.original = original;
		this.bean = bean;
	}

	public static StatusExtender valueOf(Status original) {
		return ORIGINAL_TO_EXTENDER.get(original);
	}

	public Status toOriginal() {
		return EXTENDER_TO_ORIGINAL.get(this);
	}

	private static void assertFullMapping() {
		Status[] originals = Status.values();
		for (Status original : originals) {
			if (ORIGINAL_TO_EXTENDER.get(original) == null) {
				throw new IllegalStateException("The enum "
						+ original.getClass().getSimpleName() + "." + original
						+ " has no corresponding extension in "
						+ StatusExtender.class.getSimpleName() + "!");
			}
		}
	}
}
