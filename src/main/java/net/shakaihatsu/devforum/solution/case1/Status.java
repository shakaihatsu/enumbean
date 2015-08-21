package net.shakaihatsu.devforum.solution.case1;

public enum Status {
	NEW {
		@Override
		public int processTask(Task task) {
			System.out.println("Case1: Executing " + task);
			
			return 1;
		}
	},
	FAILED {
		@Override
		public int processTask(Task task) {
			System.out.println("Case1: Retrying " + task);
			
			return 2;
		}
	},
	SUCCESSFUL {
		@Override
		public int processTask(Task task) {
			System.out.println("Case1: Archiving " + task);
			
			return 3;
		}
	},
	CANCELED {
		@Override
		public int processTask(Task task) {
			System.out.println("Case1: Deleting " + task);
			
			return 4;
		}
	};

	public abstract int processTask(Task task);
}
