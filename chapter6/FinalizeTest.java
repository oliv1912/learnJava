package chapter6;

public class FinalizeTest
{
    private static FinalizeTest ft=null;
    public void info()
    {
        System.out.println("测试资源清理的finalize方法");
    }
    public static void main(String[] args)throws Exception
    {
        //创建FinalizeTest对象立即进入可恢复状态
        new FinalizeTest();
        //通知系统进行资源回收
        System.gc();
        //强制垃圾回收机制调用可恢复对象的finalize()方法
        //Runtime.getRuntime().runFinalization();
        System.runFinalization();
        ft.info();
    }
    public void finalize()
    {
        //让tf引用试图回收的可恢复对象，即可恢复对象重新变成可达
        ft=this;
    }
}
