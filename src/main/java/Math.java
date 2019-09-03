import lombok.extern.slf4j.Slf4j;

/**
 * @author dongfei
 */
@Slf4j
public class Math {

    public static void main(String[] args) {
        int n = 17;
        log.info("n>>>1 = {}",n>>>1); //8 /2 2的m次幂 m=1
        log.info("n>>>2 = {}",n>>>2); //4 /4 m=2
        log.info("n>>>4 = {}",n>>>4); //1 /16 m=4
        log.info("n>>>8 = {}",n>>>8); //0 /32
        log.info("n>>>16 = {}",n>>>16); //0
        log.info("n>>>32 = {}",n>>>32); //17 回到17了？因为int类型再java中长度为32 4字节 一字节8bit 4*8 = 32bit

        int m = 18;
        log.info("m|m>>>1 = {}",m = m|m>>>1); //27 ？
        // 18 低位表示 10010
        // 左移1位 9  01001
        // 取或      11011  27
        // 27 左移 2 00110   左移 末尾为1进位
        //再取或     11111
        //再左移4    00001
        log.info("31>>>4 = {}",31>>>4); //31
        log.info("m|m>>>2 = {}",m= m|m>>>2); //31
        log.info("m|m>>>4 = {}",m= m|m>>>4); //31
        log.info("m|m>>>8 = {}",m = m|m>>>8); //31
        log.info("m|m>>>16 = {}",m= m|m>>>16); //31
        log.info("m|m>>>32 = {}",m=m|m>>>32); //31
        log.info("m|m>>>32 = {}",m=m|m>>>64); //31
    }
}
