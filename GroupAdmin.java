package observer;

import java.util.ArrayList;

public class GroupAdmin implements Sender {
    private ArrayList<Member> members;//list of members
    private UndoableStringBuilder AdminUsb = new UndoableStringBuilder();//the admin's string
    private String name;

    //constructor
    public GroupAdmin() { //constructor of GroupAdmin with no parameter
        members = new ArrayList<Member>();
        System.out.println("GroupAdmin created");
    }

    public GroupAdmin(String setUp ){ //set up the group admin with the first string
        members = new ArrayList<Member>();
       AdminUsb.append(setUp);
        System.out.println("GroupAdmin created");
    }
    public GroupAdmin(ArrayList<Member> members) { //constructor with a list of members
        this.members = new ArrayList<Member>(members);
        System.out.println("GroupAdmin created");
    }
    @Override
    public void register(Member member) {

        if (member == null) {
            throw new IllegalArgumentException("member cannot be null");
        }
   if (members.contains(member)==false) {
            members.add(member);
            UpdateMembers();
            System.out.println("member addition sucssesful !\n " + member);

        }
   else
   System.out.println(" the member is already in the group");
    }
    @Override
    public void unregister(Member member) {
        int done=0;

        if (member == null) {
            throw new IllegalArgumentException("member cannot be null");
        }

        for(int i=0; i<members.size(); i++)
    {
        if (members.get(i).equals(member)) {
            members.remove(i);
            System.out.println("member removal sucssesful !\n " + member);
            done=1;
        }
    }
        if (done==0) {
            System.out.println("the member is not in the group");
        }
        UpdateMembers();
    }


    @Override
    public void insert(int offset, String str) {
        if (str == null) {
            throw new IllegalArgumentException("obj cannot be null");
        }
        if(this==null)
            throw new IllegalArgumentException("the group is empty, the string is null");

        AdminUsb.insert(offset,str);
        System.out.println("Insert " + str + " at " + offset);
        UpdateMembers();
    }


    @Override
    public void append(String str) {
        if (str == null) {
            throw new IllegalArgumentException("string cannot be null");
        }
        AdminUsb.append(str);
        System.out.println("Append the string: '"+ str+ "'" + " to the end of the string");
        UpdateMembers();
    }

    @Override
    public void delete(int start, int end) { //remove characters in a substring of this sequence
        if (start < 0 || end < 0) {
            throw new IllegalArgumentException("start and end cannot be negative");
        }
        if (AdminUsb==null) {
            throw new IllegalArgumentException("usb cannot be null");
        }
        AdminUsb.delete(start, end);
        System.out.println("usb is: " + AdminUsb.toString());
        UpdateMembers();

    }

    @Override
    public void undo() {//undo the last change
        if (AdminUsb==null) {
            throw new IllegalArgumentException("Admin string is null!");
        }
        AdminUsb.undo();
        if (AdminUsb==null) {
            System.out.println("undo the last change. now,admin string is empty");
        }
        System.out.println("undo. the admin string is: " + AdminUsb.toString());
        UpdateMembers();
    }

    private void UpdateMembers() {
        for (Member member : members) {
            member.update(AdminUsb);
        }
    }

    public boolean contains(Member member) {//check if the member is in the group
        return members.contains(member);
    }

    public String getAdminUsb() { //return the admin string
        return AdminUsb.toString();
    }

    public ArrayList getMembers() { //return the members in the group
        return members;
    }
    public String toString() {
        int id=1;
     String s = "admin string: " + AdminUsb.toString() + "\n";
     s+= "the group size is: " + members.size() + "\n";
     s+= "the members are: " + "\n";
        for (Member member : members) {
           s+= id + ". " + member.toString()+"\n";
           id++;
        }
        return s;
    }
    public String printbyIndex(int inx) {//return the member in the group by index
        if (inx < 0 || inx > members.size()) {
            throw new IllegalArgumentException("index out of bound");
        }

     return members.get(inx).toString();
    }

    public int getGroupSize() {

            return members.size();
        }
    }


