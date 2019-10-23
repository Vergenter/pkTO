package factory_method;

import factory_method.interfaces.GPU;
import factory_method.interfaces.GPUFactory;

public class GPUSeller {
    GPUFactory supplier;
    public GPUSeller(GPUFactory supplier){
        this.supplier=supplier;
    }
    public GPU sellGPU(){
        return supplier.createGPU();
    }

}
