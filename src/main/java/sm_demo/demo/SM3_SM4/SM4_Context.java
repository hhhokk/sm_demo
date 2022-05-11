package sm_demo.demo.SM3_SM4;

/**
 * @author zy
 * @create 2022-05-11-22:09
 */
/**
 * Created by $(USER) on $(DATE)
 */
public class SM4_Context {
    public int mode;

    public long[] sk;

    public boolean isPadding;

    public SM4_Context()
    {
        this.mode = 1;
        this.isPadding = true;
        this.sk = new long[32];
    }
}
