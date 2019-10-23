package factory_method.implementation.GPUs;

import factory_method.interfaces.GPU;

public class RTX20xx implements GPU {
    public RTX20xx(String concreteModel){
        modelName="RTX20"+concreteModel;
    }
    String modelName;
    public String getModelName() {
        return modelName;
    }
}
