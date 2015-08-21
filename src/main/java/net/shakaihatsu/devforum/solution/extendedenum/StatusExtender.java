package net.shakaihatsu.devforum.solution.extendedenum;

import java.util.HashMap;
import java.util.Map;

import net.shakaihatsu.devforum.api.TaskProcessor;
import net.shakaihatsu.devforum.domain.Status;
import net.shakaihatsu.devforum.domain.Task;

public enum StatusExtender implements TaskProcessor {
	NEW(Status.NEW) {
		@Override
		public int processTask(Task task) {
			System.out.println("ExtendedEnum: Executing " + task);

			return 1;
		}
	},
	FAILED(Status.FAILED) {
		@Override
		public int processTask(Task task) {
			System.out.println("ExtendedEnum: Retrying " + task);

			return 2;
		}
	},
	SUCCESSFUL(Status.SUCCESSFUL) {
		@Override
		public int processTask(Task task) {
			System.out.println("ExtendedEnum: Archiving " + task);

			return 3;
		}
	},
	CANCELED(Status.CANCELED) {
		@Override
		public int processTask(Task task) {
			System.out.println("ExtendedEnum: Deleting " + task);

			return 4;
		}
	};

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

	private StatusExtender(Status original) {
		this.original = original;
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
