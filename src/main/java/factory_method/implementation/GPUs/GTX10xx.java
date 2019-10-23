package factory_method.implementation.GPUs;

import factory_method.interfaces.GPU;

public class GTX10xx implements GPU {
    public GTX10xx(String concreteModel){
        modelName="GTX10"+concreteModel;
    }
    String modelName;
    public String getModelName() {
        return modelName;
    }
}
