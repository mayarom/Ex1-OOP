package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteMemberTest {

    @Test
    void update() { //test the update method
        UndoableStringBuilder usb = new UndoableStringBuilder("first string");
        ConcreteMember member1 = new ConcreteMember("maya");
        member1.update(usb);
        //check if the string was updated
        assertEquals("first string",member1.toString());
    }
    @Test
    void toString1() {//test the toString method
        UndoableStringBuilder usb = new UndoableStringBuilder("first string");
        ConcreteMember member1 = new ConcreteMember("maya");
        member1.update(usb);
        //check if the string was updated
        assertEquals("maya, your string is: first string",member1.toString());
    }



}
