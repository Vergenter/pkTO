package factory_method.implementation.GPUsConcreteFactories;

import factory_method.implementation.GPUs.RTX20xx;
import factory_method.interfaces.GPU;
import factory_method.interfaces.GPUFactory;


public class RTX20xxFactory implements GPUFactory {
    String model;
    public  RTX20xxFactory(String modelData)  {
        this.model=modelData;
    }

    public void changeModel(String newModel){
        model=newModel;
    }
    public GPU createGPU() {
        return new RTX20xx(model);
    }
}
