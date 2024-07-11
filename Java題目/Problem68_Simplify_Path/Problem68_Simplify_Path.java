/**
Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.

In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.

The canonical path should have the following format:

The path starts with a single slash '/'.
Any two directories are separated by a single slash '/'.
The path does not end with a trailing '/'.
The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
Return the simplified canonical path.
 */
package Problem68_Simplify_Path;
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem68_Simplify_Path{

    public static void main(String[] args) {

        Solution solution = new Solution();
        String temp = "/home//foo/";
        System.out.println(solution.simplifyPath(temp));

    }
}
//尾部沒有"/"
//多個"/"可視為一個"/"
//".."->忽略當層
//"."
class Solution {
    public String simplifyPath(String path) {
        List<String> ans = new ArrayList<>();
        String[] temp = path.split("/");
        for(String i: temp){
            if(i.equals("..") && ans.size()!=0){ans.remove(ans.size()-1);}
            else if(!i.equals("") && !i.equals(".") && !i.equals("..")){ans.add(i);}
        }
        StringBuilder answer = new StringBuilder();
        answer.append("/");
        for(String i: ans){
            answer.append(i);
            answer.append("/");
        }
        if(answer.length()!=1){answer.deleteCharAt(answer.length()-1);}
        return answer.toString();

    }
}