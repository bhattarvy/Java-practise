package testing;

import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.List;
import static org.mockito.Mockito.*;


public class MockitoBasics {

    public void testMockBasics(){
        List mockList = Mockito.mock(List.class);
        mockList.add("one");
        mockList.clear();

        verify(mockList).add("one");
        verify(mockList).clear();

        LinkedList mockedLinkedList = mock(LinkedList.class);

        when(mockedLinkedList.get(0)).thenReturn("first");
        when(mockedLinkedList.get(1)).thenThrow(new RuntimeException());

        System.out.println(mockedLinkedList.get(0));
        //System.out.println(mockedLinkedList.get(1));
        System.out.println(mockedLinkedList.get(99));

        verify(mockedLinkedList).get(0);

    }

    public void testClassToBeTest(){

        ClassToBeTest classToBeTest = mock(ClassToBeTest.class);

        when(classToBeTest.someMethod(anyInt(),anyInt(),anyString())).thenReturn("some method");

        classToBeTest.someMethod(3,4,"sdfd");
        verify(classToBeTest).someMethod(anyInt(),anyInt(),eq("sdfd"));
    }

    public void testVoidMethod() {
        ClassToBeTest classToBeTest = mock(ClassToBeTest.class);
        doThrow(new RuntimeException()).when(classToBeTest).voidMethod();
    }

    public static void main(String[] args) {
        MockitoBasics mockitoBasics = new MockitoBasics();
        //mockitoBasics.testClassToBeTest();
        mockitoBasics.testVoidMethod();
    }

}
