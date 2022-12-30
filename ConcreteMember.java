package observer;

import java.util.Stack;

public class ConcreteMember implements Member {
    private UndoableStringBuilder usb;
    String name;


    public ConcreteMember(String name) {
        this.usb = new UndoableStringBuilder();
        this.name = name;
    }

    @Override
    public void update(UndoableStringBuilder usb) { //update the member
        System.out.println( this.name + ", the admin update your string to: "+ usb.toString());
        this.usb = usb;
    }
    public String toString() {//return the current string
        if (this==null) { //if the member is null
            throw new IllegalArgumentException("the group is empty, the string is null");
        }
        else{ //return the string
           return(this.name + ", your string is: " + this.usb.toString());

        }

    }


}

