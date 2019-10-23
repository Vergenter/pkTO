package factory_method.implementation.GPUsConcreteFactories;

import factory_method.implementation.GPUs.GTX10xx;
import factory_method.interfaces.GPU;
import factory_method.interfaces.GPUFactory;

public class GTX1080Factory implements GPUFactory {
    public GPU createGPU() {
        return new GTX10xx("80");
    }
}
