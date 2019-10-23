package factory_method_Tests;

import factory_method.GPUSeller;
import factory_method.implementation.GPUs.GTX10xx;
import factory_method.implementation.GPUs.GTX9xx;
import factory_method.implementation.GPUs.RTX20xx;
import factory_method.implementation.GPUsConcreteFactories.GTX1080Factory;
import factory_method.implementation.GPUsConcreteFactories.GTXFactory;
import factory_method.implementation.GPUsConcreteFactories.RTX20xxFactory;
import factory_method.interfaces.GPU;
import factory_method.interfaces.GPUFactory;
import org.junit.jupiter.api.Test;

import javax.imageio.IIOException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class PatternTest {
    @Test
    void getAnyGPU() {
        GPUFactory supplier = new GTX1080Factory();
        GPUSeller seller= new GPUSeller(supplier);
        boolean expected=true;
        boolean actual = seller.sellGPU() instanceof GPU;
        assertEquals(expected,actual);
    }
    @Test
    void getGTX1080() {
        String GPUModel = "1080";
        GPUFactory supplier = new GTX1080Factory();
        GPUSeller seller= new GPUSeller(supplier);
        boolean expected=true;
        boolean actual = seller.sellGPU() instanceof GTX10xx && seller.sellGPU().getModelName().contains(GPUModel);
        assertEquals(expected,actual);
    }
    @Test
    void getRTX2060() {
        String GPUSubModel = "60";
        GPUFactory supplier = new RTX20xxFactory(GPUSubModel);
        GPUSeller seller= new GPUSeller(supplier);
        boolean expected=true;
        boolean actual = seller.sellGPU() instanceof RTX20xx && seller.sellGPU().getModelName().contains(GPUSubModel);
        assertEquals(expected,actual);
    }
    @Test
    void getRTX2050andRTX2070(){
        String GPUFirstSubModel = "50";
        String GPUSecondSubModel = "70";
        GPUFactory supplier = new RTX20xxFactory(GPUFirstSubModel);
        GPUSeller seller= new GPUSeller(supplier);
        GPU firstGPU=seller.sellGPU();
        ((RTX20xxFactory)supplier).changeModel(GPUSecondSubModel);
        GPU secondGPU=seller.sellGPU();

        boolean expectedGPUModelsAreSame=false;
        boolean actualGPUNameRelation = firstGPU.getModelName()==secondGPU.getModelName();
        assertEquals(expectedGPUModelsAreSame,actualGPUNameRelation);

        boolean expectedGPUModelsAreCorrect=true;
        boolean actualGPUModelsCorrectness = firstGPU.getModelName().contains(GPUFirstSubModel)&&secondGPU.getModelName().contains(GPUSecondSubModel);
        assertEquals(expectedGPUModelsAreCorrect,actualGPUModelsCorrectness);
    }
    @Test
    void getGTX1070() {
        String GPUSubModel = "70";
        GPUFactory supplier;
        try {
            supplier = new GTXFactory(10, GPUSubModel);
        } catch (IOException e){
            fail("Exception thrown");
            return;
        }
        GPUSeller seller= new GPUSeller(supplier);
        boolean expected=true;
        boolean actual = seller.sellGPU() instanceof GTX10xx && seller.sellGPU().getModelName().contains(GPUSubModel);
        assertEquals(expected,actual);
    }
    @Test
    void getGTX980(){
        String GPUSubModel = "80";
        GPUFactory supplier;
        try {
            supplier = new GTXFactory(9, GPUSubModel);
        } catch (IOException e){
            fail("Exception thrown");
            return;
        }
        GPUSeller seller= new GPUSeller(supplier);
        boolean expected=true;
        boolean actual = seller.sellGPU() instanceof GTX9xx && seller.sellGPU().getModelName().contains(GPUSubModel);
        assertEquals(expected,actual);
    }
    }
