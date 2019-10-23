package factory_method.implementation.GPUsConcreteFactories;

import factory_method.implementation.GPUs.GTX10xx;
import factory_method.implementation.GPUs.GTX9xx;
import factory_method.interfaces.GPU;
import factory_method.interfaces.GPUFactory;

import java.io.IOException;

public class GTXFactory implements GPUFactory {
    int generation;
    String model;
    public GTXFactory(int Generation,String modelData) throws IOException {
        if(Generation!=9&&Generation!=10){
            throw new IOException("No GPU generation like this");
        }
        this.generation=Generation;
        this.model=modelData;
    }
    public GPU createGPU()  {
        if(generation==9){
            return new GTX9xx(model);
        } else{
            return new GTX10xx(model);
        }

    }
}
