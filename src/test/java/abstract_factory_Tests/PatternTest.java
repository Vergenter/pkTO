package abstract_factory_Tests;

import abstract_factory.ComputerPartSelector;
import abstract_factory.PC;
import abstract_factory.implementation.AMDFactory;
import abstract_factory.implementation.AMDProcessor;
import abstract_factory.implementation.IntelFactory;
import abstract_factory.implementation.IntelProcessor;
import abstract_factory.interfaces.ComputerFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PatternTest {
    @Test
    void getAnyPC() {
        ComputerFactory factory= new AMDFactory();
        ComputerPartSelector partSelector = new ComputerPartSelector(factory);
        boolean expected=true;
        boolean actual = partSelector.getPC() instanceof PC;
        assertEquals(expected,actual);
    }
    @Test
    void getIntelPC() {
        ComputerFactory factory= new IntelFactory();
        ComputerPartSelector partSelector = new ComputerPartSelector(factory);
        PC pc = partSelector.getPC();
        boolean expectedSocketCompatibility=true;
        boolean actual = pc.getCpu().getRequiredSocket()==pc.getMobo().getAvaibleSocket();
        assertEquals(expectedSocketCompatibility,actual);
        boolean expectedProcessorType=true;
        actual = partSelector.getPC().getCpu() instanceof IntelProcessor;
        assertEquals(expectedProcessorType,actual);
    }
    @Test
    void getAmdPC() {
        ComputerFactory factory= new AMDFactory();
        ComputerPartSelector partSelector = new ComputerPartSelector(factory);
        PC pc = partSelector.getPC();
        boolean expectedSocketCompatibility=true;
        boolean actual = pc.getCpu().getRequiredSocket()==pc.getMobo().getAvaibleSocket();
        assertEquals(expectedSocketCompatibility,actual);
        boolean expectedProcessorType=true;
        actual = partSelector.getPC().getCpu() instanceof AMDProcessor;
        assertEquals(expectedProcessorType,actual);
    }
    @Test
    void getDiffrentInstances() {
        ComputerFactory factory= new AMDFactory();
        ComputerPartSelector partSelector = new ComputerPartSelector(factory);
        PC pc1 = partSelector.getPC();
        PC pc2 = partSelector.getPC();
        boolean expectedSamePC=false;
        boolean actual = pc1==pc2;
        assertEquals(expectedSamePC,actual);
        boolean expectedSameElements=false;
        actual = pc1.getCpu()==pc2.getCpu()||pc1.getMobo()==pc2.getMobo();
        assertEquals(expectedSameElements,actual);
    }


}
