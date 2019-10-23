package abstract_factory.implementation;

import abstract_factory.interfaces.CPU;

public class IntelProcessor implements CPU {
    public int getRequiredSocket() {
        return 1151;
    }
}
