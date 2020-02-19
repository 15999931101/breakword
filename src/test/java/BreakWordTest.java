import com.llp.BreakWord;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BreakWordTest {


    @Test
    public void breakWordTest() {
        BreakWord bw = new BreakWord();
        String str = "ilikesamsungmobile";
        Set dict = new HashSet();
        List<String> lit = bw.wordBreak(str,dict,null);
        System.out.println("********普通字典输出***********");
        lit.stream().forEach(outputStr -> System.out.println(outputStr));
    }


    @Test
    public void sigleDicTest() {
        BreakWord bw = new BreakWord();
        String str = "ilikewatchingtv";
        Set dict = new HashSet();
        dict.add("i");
        dict.add("like");
        dict.add("watching");
        dict.add("tv");
        List<String> lit = bw.wordBreak(str,dict,"single");
        System.out.println("********使用自定义字典输出***********");
        lit.stream().forEach(outputStr -> System.out.println(outputStr));
    }

    @Test
    public void allDicTest() {
        BreakWord bw = new BreakWord();
        String str = "ilikereadingbooks";
        Set dict = new HashSet();
        dict.add("i");
        dict.add("like");
        dict.add("reading");
        dict.add("books");
        List<String> lit = bw.wordBreak(str,dict,"all");
        System.out.println("********默认字典与自定义字典合并字典输出***********");
        lit.stream().forEach(outputStr -> System.out.println(outputStr));
    }



}
