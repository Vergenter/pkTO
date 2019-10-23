package abstract_factory.implementation;

import abstract_factory.interfaces.CPU;

public class AMDProcessor implements CPU {
    public int getRequiredSocket() {
        return 940;
    }
}
