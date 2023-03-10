package observer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class GroupAdminTests {

    GroupAdmin lord;
    GroupAdmin dror;

    public static final Logger logger =  LoggerFactory.getLogger(GroupAdminTest.class);

    @BeforeAll
    static void beforeAll() {
        System.out.println("Junit test for GroupAdmin:");
        GroupAdmin lord = new GroupAdmin("erch");
        GroupAdmin dror = new GroupAdmin();
        ConcreteMember miki = new ConcreteMember("miki");

    }
    @BeforeEach
    void setUp() { //
        System.out.println("Set up :");
        lord = new GroupAdmin("erch erch");
        dror = new GroupAdmin();
        //member 1,2,3 --> lord
        final ConcreteMember member1 = new ConcreteMember("maya");
        lord.register(member1);
       final  ConcreteMember member2 = new ConcreteMember("avichi");
        lord.register(member2);
        final ConcreteMember member3 = new ConcreteMember("itay");
        lord.register(member3);
        //member 4,5,6 --> dror
       final ConcreteMember member4 = new ConcreteMember("michael");
        dror.register(member4);
        final ConcreteMember member5 = new ConcreteMember("guy");
        dror.register(member5);
       final  ConcreteMember miki = new ConcreteMember("miki");
        dror.register(miki);
        
        System.out.println("---------------------------------------------------");
    }

    @Test
    void register() {
        System.out.println("***** register test: *****");
        //check if the member was added to the group
        ConcreteMember miki= new ConcreteMember("erch erch");
        lord.register(miki);
        System.out.println("the new group size is: " + lord.getGroupSize());
        System.out.println(lord);
        System.out.println("____________________________________________________");
        //lord info
        System.out.println("lord info:"); // use logger
        logger.info(()->JvmUtilities.objectFootprint(lord));
        logger.info(()->JvmUtilities.objectTotalSize(lord));

        System.out.println("dror info:"); // use logger
        logger.info(()->JvmUtilities.objectFootprint(lord));
        logger.info(()->JvmUtilities.objectTotalSize(lord));

        //check if the member was added to the group
        assertEquals(4, lord.getMembers().size());//check if the members were added to the group

    }

    @Test
    void unregister() {

        System.out.println("***** unregister test: *****");
        System.out.println("at start, the group size is: " + lord.getGroupSize());
        ConcreteMember miki = new ConcreteMember("miki");
        lord.register(miki);
        logger.info(()->JvmUtilities.objectTotalSize(lord));
        assertEquals(4, lord.getMembers().size());//check if the members were added to the group
        System.out.println("at start, the group size is: " + lord.getGroupSize());
        lord.unregister(miki);
        logger.info(()->JvmUtilities.objectTotalSize(lord));
        assertEquals(3, lord.getMembers().size());//check if the members were added to the group
        System.out.println("after unregister, the group size is: " + lord.getGroupSize());
        System.out.println("____________________________________________________");
        //logger information
        System.out.println("logger info:"); // use logger
        logger.info(() -> JvmUtilities.jvmInfo());
    }
        @Test
        void insert () {
            System.out.println("***** insert test: *****");
            //insert a string
            lord.insert(0, "eeeerch ");
            System.out.println("____________________________________________________");
            //check if the string was inserted
            assertEquals("eeeerch erch erch", lord.getAdminUsb().toString());
        }

        @Test
        void append () {
            System.out.println("***** append test: *****");

            //append a string
            lord.append(" erch");
            dror.append("once in a");
            dror.append(" while");
            System.out.println("____________________________________________________");
            //check if the string was appended
            assertEquals("erch erch erch", lord.getAdminUsb().toString());
            assertEquals("once in a while", dror.getAdminUsb().toString());
        }

        @Test
        void delete () {
            System.out.println("***** delete test: *****");
            //delete a string
            lord.delete(0, 5);
            dror.append("erch , erch , erch");
            dror.delete(0,0);
            System.out.println("____________________________________________________");
            //check if the string was deleted
            assertEquals("erch , erch , erch", dror.getAdminUsb().toString(),"dror must be 'erch , erch , erch' ");
            assertEquals("erch", lord.getAdminUsb().toString(),"lord must be 'erch' ");
        }
        @Test
        void undo () {
        System.out.println("***** undo test: *****");
            lord.append("eeeerch!");
            System.out.println("lord address before undo");
            logger.info(()->JvmUtilities.objectFootprint(lord));
            //undo the last change
            lord.undo();
            System.out.println("lord address after undo");
            logger.info(()->JvmUtilities.objectFootprint(lord));
            System.out.println("____________________________________________________");
            //check if the last change was undone
            assertEquals("erch erch", lord.getAdminUsb().toString());

        }


    }
