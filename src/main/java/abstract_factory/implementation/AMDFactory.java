package abstract_factory.implementation;

import abstract_factory.interfaces.CPU;
import abstract_factory.interfaces.ComputerFactory;
import abstract_factory.interfaces.MoBo;

public class AMDFactory implements ComputerFactory {
    public CPU createCPU() {
        return new AMDProcessor();
    }

    public MoBo createMoBo() {
        return new Asus();
    }
}
