package TimeTypeTask;

public enum TimeTypeTask {
    WEEKLY{
        @Override
        public Task newTask() {
            return new Weekly();
        }
    },
    MONTHLY{
        @Override
        public Task newTask() {
            return new  Monthly();
        }
    },
    DAILY{
        @Override
        public Task newTask() {
            return new  Daily();
        }
    },
    YEARLY{
        @Override
        public Task newTask() {
            return new  Daily();
        }
    },
    ONETIME{
        @Override
        public Task newTask() {
            return new OneTime();
        }
    };
    public abstract Task newTask();
}
