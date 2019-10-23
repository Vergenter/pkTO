package abstract_factory;

import abstract_factory.interfaces.ComputerFactory;

public class ComputerPartSelector {
    ComputerFactory computerFactory;
    public ComputerPartSelector(ComputerFactory computerFactory){
        this.computerFactory=computerFactory;
    }
    public PC getPC(){
        return new PC(computerFactory.createCPU(),computerFactory.createMoBo());
    }
}
