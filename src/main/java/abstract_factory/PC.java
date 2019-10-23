package abstract_factory;

import abstract_factory.interfaces.CPU;
import abstract_factory.interfaces.MoBo;

public class PC {
    CPU cpu;
    MoBo mobo;
    public PC(CPU cpu,MoBo mobo){
        this.cpu=cpu;
        this.mobo=mobo;
    }
    public CPU getCpu(){
        return cpu;
    }
    public MoBo getMobo(){
        return mobo;
    }
}
