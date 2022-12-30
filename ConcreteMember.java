package observer;

public class ConcreteMember implements Member {

    UndoableStringBuilder usb;//usb is the object of UndoableStringBuilder class
    String name;//name is the name of the member


    @Override
    public void update(UndoableStringBuilder usb) {
        System.out.println("The string has been changed to: " + usb.toString());
    }
}

