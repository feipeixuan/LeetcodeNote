package java;

/**
 * Created by feipeixuan on 2017/2/17.
 */
public class PrivateThisTest {
}

class A
{
    private int b;

    public void say(A a)
    {
        System.out.println(a.b);
    }
}
