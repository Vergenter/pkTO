package factory_method.implementation.GPUs;

import factory_method.interfaces.GPU;

public class GTX9xx implements GPU {
    public GTX9xx(String concreteModel){
        modelName="GTX9"+concreteModel;
    }
    String modelName;
    public String getModelName() {
        return modelName;
    }
}
