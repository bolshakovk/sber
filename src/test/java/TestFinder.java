import org.example.Finder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class TestFinder {
    Finder finder = new Finder();
    @Test
    public void testGoodInput(){
        assertEquals("номер найден",finder.printAnswer("405") );
    }
    @Test
    public void testGoodInputWithSpaces(){
        assertEquals("номер найден", finder.printAnswer("4 0 5") );
    }
    @Test
    public void testNoString(){
        assertEquals("Инвалидная строка", finder.printAnswer("") );
    }
    @Test
    public void testWrongLenString(){
        assertEquals("Инвалидная строка", finder.printAnswer("51") );
    }
}
